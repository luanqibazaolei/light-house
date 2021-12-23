package com.light.mng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.mng.entity.UserInfo;
import com.light.mng.entity.dto.UserDto;
import com.light.mng.mapper.UserInfoMapper;
import com.light.mng.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;


    public UserDto loadUserByUsername(String username)
    {
        return userInfoMapper.selectUserByUsername(username);
    }
}

