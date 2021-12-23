package com.light.mng.entity.dto;

import com.light.mng.entity.Role;
import com.light.mng.entity.UserInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDto extends UserInfo {

    private Set<Role> roles;


}
