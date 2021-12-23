package com.light.mng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.light.mng.entity.BandInfo;
import com.light.mng.entity.UserInfo;
import com.light.mng.entity.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 乐队信息表 Mapper 接口
 * </p>
 *
 * @author light
 * @since 2021-12-23
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserDto selectUserByUsername(@Param("username") String username);

}
