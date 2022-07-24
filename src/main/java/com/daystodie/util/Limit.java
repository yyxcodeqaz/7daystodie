package com.daystodie.util;


import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 接口限流的注解
 * @author leaf
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface Limit {
    //资源key
    String key() default "";

    // 最多访问次数
    double permitsPerSecond();

    // 时间
    long timeout();

    // 时间类型
    TimeUnit timeunit() default TimeUnit.MILLISECONDS;

    // 提示信息
    String msg() default "系统繁忙,请稍后再试";
}
