package com.daystodie.advice;

import com.daystodie.entity.vo.Result;
import com.daystodie.exception.DaysException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author leaf
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 系统异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.error(e.getLocalizedMessage());
    }

    /**
     * 自定义异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(DaysException.class)
    @ResponseBody
    public Result divError(DaysException e) {
        return Result.error(e.getMessage());
    }
}