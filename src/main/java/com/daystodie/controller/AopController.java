package com.daystodie.controller;

import com.daystodie.entity.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 统一异常拦截
 *
 * @author leaf
 */
@Slf4j
public class AopController {
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();

        ResultVo<?> result;

        try {
            result = (ResultVo<?>) pjp.proceed();
            log.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }

        return result;
    }

    private ResultVo<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        ResultVo<?> result = new ResultVo();

        // 已知异常
        if (e instanceof Exception) {
            result.setMsg(e.getLocalizedMessage());
            result.setCode(ResultVo.FAIL);
        } else {
            log.error(pjp.getSignature() + " error ", e);
            //TODO 未知的异常，应该格外注意，可以发送邮件通知等
            assert false;
            result.setMsg(e.toString());
            result.setCode(ResultVo.FAIL);
        }

        return result;
    }
}
