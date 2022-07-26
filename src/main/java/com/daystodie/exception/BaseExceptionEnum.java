package com.daystodie.exception;

import lombok.AllArgsConstructor;

/**
 * 自定义基础异常枚举
 *
 * @author leaf
 */
@AllArgsConstructor
public enum BaseExceptionEnum implements SuperEnumFace {

    /**
     * 返回状态码
     */
    SUCCESS(200, "操作成功"),
    FAIL(400, "操作失败"),
    NOT_FOUND(404, "无法访问"),
    ERROR(500, "服务器异常，请稍后重试"),
    LOGIN_EXPIRE(600, "获取失败，请重新获取");

    private final int code;
    private final String message;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}