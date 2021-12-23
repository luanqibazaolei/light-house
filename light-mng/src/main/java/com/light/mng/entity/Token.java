package com.light.mng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token implements Serializable {

    private static final long serialVersionUID = -164567294469931676L;

    /**
     * token
     */
    private String token;
    /**
     * 登陆时间戳（毫秒）
     */
    private Long loginTime;

}
