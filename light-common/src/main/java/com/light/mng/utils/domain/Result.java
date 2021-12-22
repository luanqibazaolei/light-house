package com.light.mng.utils.domain;


import com.light.mng.utils.ResultEnum;

import java.io.Serializable;

public class Result implements Serializable {
    protected String code;
    protected String msg;

    public Result() {
    }

    public Result(Boolean b){
        this.code = ResultEnum.SUCCESS.code;
        this.msg = ResultEnum.SUCCESS.msg;
    }
    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result ofSuccess() {
        return of(ResultEnum.SUCCESS.code, ResultEnum.SUCCESS.msg);
    }

    public static Result ofError() {
        return of(ResultEnum.ERROR.code, ResultEnum.ERROR.msg);
    }

    public static Result of(String code, String msg) {
        Result instance = new Result(code, msg);
        return instance;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Result)) {
            return false;
        } else {
            Result other = (Result)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$code = this.getCode();
                Object other$code = other.getCode();
                if (this$code == null) {
                    if (other$code != null) {
                        return false;
                    }
                } else if (!this$code.equals(other$code)) {
                    return false;
                }

                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Result;
    }


    public String toString() {
        return "Result(code=" + this.getCode() + ", msg=" + this.getMsg() + ")";
    }
}
