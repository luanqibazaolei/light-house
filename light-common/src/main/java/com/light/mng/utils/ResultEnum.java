package com.light.mng.utils;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import org.apache.commons.lang3.StringUtils;

public enum ResultEnum {
    SUCCESS("0000", "请求成功"),
    NO_AUTH("0100", "未登录"),
    PASSED_TOKEN_ERROR("0101", "token过期"),
    INVALID_TOKEN_ERROR("0102", "token异常"),
    PARAMS_ERROR("0103", "参数错误"),
    ERROR("9999", "请求失败"),
    SQL_UNIQUE_CONSTRAINT_ERROR("9001", "sql唯一键冲突异常");

    public String code;
    public String msg;

    private ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultEnum codeOf(String code) {
        if (StringUtils.isNotEmpty(code)) {
            ResultEnum[] values = values();

            for(int i = 0; i < values.length; ++i) {
                if (code.equals(values[i].code)) {
                    return values[i];
                }
            }
        }

        return null;
    }
}
