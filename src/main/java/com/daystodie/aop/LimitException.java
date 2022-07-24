package com.daystodie.aop;

import lombok.extern.slf4j.Slf4j;

/**
 * 一定时间内接口请求超过一定次数报错
 *
 * @author leaf
 */
@Slf4j
public class LimitException extends RuntimeException {
    public LimitException(String msg) {
        super(msg);
    }
}
