package com.light.mng.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("user")
@ApiModel(value="ShowInfo对象", description="演出表")
public class UserInfo {
    @TableId("uid")
    private Long uid;
    private String username;
    private String password;
}
