package com.light.mng.utils;

public class MngExceptionUtils extends RuntimeException{

    protected String code;
    protected String msg;

    public MngExceptionUtils(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("出现自定义系统异常，错误码：" + this.code + ";错误信息：" + this.msg);
        return buffer.toString();
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MngExceptionUtils() {
    }


}
