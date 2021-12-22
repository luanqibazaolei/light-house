package com.light.mng.utils.domain;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import com.light.mng.utils.ResultEnum;
import com.light.mng.utils.domain.ModelResult;

public class CountResult extends ModelResult<Long> {
    public CountResult() {
    }

    public CountResult(String code, String msg, Long data) {
        super(code, msg, data);
    }

    public CountResult(String code, String msg) {
        this(code, msg, (Long)null);
    }

    public CountResult(Long data) {
        this(ResultEnum.SUCCESS.code, ResultEnum.SUCCESS.msg, data);
    }

    public static CountResult of(String code, String msg) {
        CountResult instance = new CountResult(code, msg);
        return instance;
    }
}
