package com.daystodie.advice;

import com.daystodie.entity.vo.Result;
import com.daystodie.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 *
 * @author leaf
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * 处理业务异常
     *
     * @param baseException
     * @return
     */
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public Result exceptionHandler(BaseException baseException) {
        log.error("业务异常：{}", baseException.getMessage());
        return Result.error(baseException.getMessage());
    }

    /**
     * 未知异常处理
     *
     * @param exception
     * @return
     */
    public Result exceptionHandler(Exception exception) {
        log.error("运行时异常：{}", exception.getMessage());
        return Result.error(null);
    }
}
