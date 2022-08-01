package com.daystodie.entity.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * 统一json数据格式
 *
 * @author leaf
 */
@Data
@ToString
public class ResultVo<T> {

    public static final int NO_LOGIN = -1;

    public static final int SUCCESS = 0;

    public static final int FAIL = 1;

    public static final int NO_PERMISSION = 2;
    private String msg = "success";

    private int code = SUCCESS;

    private T data;

    public ResultVo() {
        super();
    }

    public ResultVo(T data) {
        super();
        this.data = data;
    }

    public ResultVo(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = FAIL;
    }
}
