package com.daystodie.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义全局异常类
 *
 * @author leaf
 */
@Getter
@Setter
public class DaysException extends RuntimeException {

    private Integer code;

    /**
     * 通过状态码和错误消息创建异常对象
     *
     * @param message
     * @param code
     */
    public DaysException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型对象
     *
     * @param resultCodeEnum
     */
    public DaysException(BaseExceptionEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "DaysException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}