package com.light.mng.controller;

import com.light.mng.entity.dto.UserDto;
import com.light.mng.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mng/user")
@Slf4j
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/get-user")
    public UserDto getUser(@RequestParam String username){
        return userInfoService.loadUserByUsername(username);
    }

    /**
     * 查看登录用户信息
     */
    @GetMapping("/get-auth")
    public Authentication getAuth(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @PostMapping("/addUser")
    public Authentication addUser(){
        log.info("[管理站]");
        return SecurityContextHolder.getContext().getAuthentication();
    }


}


