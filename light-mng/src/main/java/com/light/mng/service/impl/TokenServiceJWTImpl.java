//package com.light.mng.service.impl;
//
//import com.light.mng.entity.dto.LoginUser;
//import com.light.mng.entity.Token;
//import com.light.mng.service.TokenService;
//import com.light.mng.utils.TokenUtil;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.collections4.MapUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.spec.SecretKeySpec;
//import javax.servlet.http.HttpServletRequest;
//import javax.xml.bind.DatatypeConverter;
//import java.security.Key;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//import java.util.UUID;
//import java.util.concurrent.TimeUnit;
//
//@Slf4j
//@Component
//public class TokenServiceJWTImpl implements TokenService {
//
//    @Value("${token.expire.seconds}")
//    private Integer expire;
//
//    @Value("${token.jwtSecret}")
//    private String jwtSecret;
//
//    private static Key KEY = null;
//
//    private static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";
//
//    @Autowired
//    private RedisTemplate<String, LoginUser> redisTemplate;
//
////    @Autowired
////    private SysLogService sysLogService;
//
//    @Autowired
//    private HttpServletRequest request;
//
//    @Override
//    public Token saveToken(LoginUser loginUser) {
//        loginUser.setToken(UUID.randomUUID().toString());
//        cacheLoginUser(loginUser);
//        // 登陆日志
//        String ip = Optional.ofNullable(request.getHeader("X-Real-IP"))
//                .filter(StringUtils::isNotBlank).orElse(request.getRemoteHost());
////        SysLogReq sysLogReq = new SysLogReq(loginUser.getId(), ip,
////                loginUser.getNickName(),"登录", 1, null);
////        sysLogService.add(sysLogReq);
//        String jwtToken = createJWTToken(loginUser);
//        return new Token(jwtToken, loginUser.getLoginTime());
//    }
//
//    //缓存token到redis
//    private void cacheLoginUser(LoginUser loginUser) {
//        loginUser.setLoginTime(System.currentTimeMillis());
//        loginUser.setExpireTime(loginUser.getLoginTime() + expire * 1000);
//        // 根据token将loginUser缓存
//        redisTemplate.boundValueOps(getTokenKey(loginUser.getToken()))
//                .set(loginUser, expire, TimeUnit.SECONDS);
//    }
//
//    //定制jwt令牌
//    private String createJWTToken(LoginUser loginUser) {
//        // 荷载部分放入token，通过该串可找到登陆用户
//        Map<String, Object> claims = new HashMap<>();
//        claims.put(LOGIN_USER_KEY, loginUser.getToken());
//        //签发令牌
//        String jwtToken = TokenUtil.sign(loginUser.getUid());
//        return jwtToken;
//    }
//
//    //定制公钥
//    private Key getKeyInstance() {
//        if (KEY == null) {
//            synchronized (TokenServiceJWTImpl.class) {
//                if (KEY == null) {
//                    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwtSecret);
//                    KEY = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
//                }
//            }
//        }
//        return KEY;
//    }
//
//    @Override
//    public void refresh(LoginUser loginUser) {
//        cacheLoginUser(loginUser);
//    }
//
//    @Override
//    public LoginUser getLoginUser(String jwtToken) {
//        String token = parseJWT(jwtToken);
//        if (StringUtils.isNotBlank(token)) {
//            return redisTemplate.boundValueOps(getTokenKey(token)).get();
//        }
//        return null;
//    }
//
//    //解析jwt令牌, 拿到荷载中的token
//    private String parseJWT(String jwtToken) {
//        if ("null".equals(jwtToken) || StringUtils.isBlank(jwtToken)) {
//            return null;
//        }
//        try {
//            Map<String, Object> jwtClaims = Jwts.parser()
//                    .setSigningKey(getKeyInstance())
//                    .parseClaimsJws(jwtToken).getBody();
//            return MapUtils.getString(jwtClaims, LOGIN_USER_KEY);
//        } catch (ExpiredJwtException e) {
//            log.error("{}已过期", jwtToken);
//        } catch (Exception e) {
//            log.error("{}", e);
//        }
//        return null;
//    }
//
//    @Override
//    public boolean deleteToken(String jwtToken) {
//        String token = parseJWT(jwtToken);
//        if (StringUtils.isNotBlank(token)) {
//            String key = getTokenKey(token);
//            LoginUser loginUser = redisTemplate.opsForValue().get(key);
//            if (loginUser != null) {
//                redisTemplate.delete(key);
//                // 退出日志
////                String ip = Optional.ofNullable(request.getHeader("X-Real-IP"))
////                        .filter(StringUtils::isNotBlank).orElse(request.getRemoteHost());
////                SysLogReq sysLogReq = new SysLogReq(loginUser.getId(), ip,
////                        loginUser.getNickName(),"退出", 1, null);
////                sysLogService.add(sysLogReq);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    //定制redisKey
//    private String getTokenKey(String token) {
//        return "tokens:" + token;
//    }
//
//}