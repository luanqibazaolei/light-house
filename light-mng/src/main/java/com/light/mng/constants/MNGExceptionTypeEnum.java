package com.light.mng.constants;

import com.light.mng.utils.MngExceptionUtils;

public enum MNGExceptionTypeEnum {

    USER_NOT_FOUND(new MngExceptionUtils("400","用户不存在")),
    PASSWORD_ERR(new MngExceptionUtils("4001","密码错误"))

    ;

    private final MngExceptionUtils exception;

    MNGExceptionTypeEnum(MngExceptionUtils exception) {
        this.exception = exception;
    }

    public MngExceptionUtils err(){
        return this.exception;
    }

    public MngExceptionUtils err(String msg){
        this.exception.setMsg(msg);
        return this.exception;
    }

}
