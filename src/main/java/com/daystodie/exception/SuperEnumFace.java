package com.daystodie.exception;


/**
 * 异常枚举父类接口
 *
 * @author leaf
 */
public interface SuperEnumFace {
    /**
     * 获取状态码
     *
     * @return
     */
    public int getCode();

    /**
     * 获取响应消息
     *
     * @return
     */
    public String getMessage();
}