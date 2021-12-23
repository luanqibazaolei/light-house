package com.light.mng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.light.mng.entity.UserInfo;
import com.light.mng.entity.dto.UserDto;

public interface UserInfoService extends IService<UserInfo> {

     UserDto loadUserByUsername(String userName);

}


