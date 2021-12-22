package com.light.mng.utils.domain;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import com.light.mng.utils.ResultEnum;
import com.light.mng.utils.domain.Result;

public class ModelResult<T> extends Result {
    protected T data;

    public ModelResult() {
    }

    public ModelResult(T data) {
        this(ResultEnum.SUCCESS.code, ResultEnum.SUCCESS.msg, data);
    }

    public ModelResult(String code, String msg, T data) {
        super(code, msg);
        this.data = data;
    }

    public static ModelResult of(String code, String msg) {
        ModelResult instance = new ModelResult(code, msg, (Object)null);
        return instance;
    }

    public T getData() {
        return this.data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ModelResult)) {
            return false;
        } else {
            ModelResult<?> other = (ModelResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ModelResult;
    }


    public String toString() {
        return "ModelResult(data=" + this.getData() + ")";
    }
}
