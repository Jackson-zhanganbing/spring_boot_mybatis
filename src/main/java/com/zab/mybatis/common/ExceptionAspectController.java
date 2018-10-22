package com.zab.mybatis.common;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ExceptionAspectController {

    @Pointcut("execution(* com.zab.mybatis.service.impl.*.*(..))")//此处基于自身项目的路径做具体的设置
    public void pointCut(){}

    @Around("pointCut()")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) {

        GeneralResponse<?> GeneralResponse;
        try {
            log.info("执行Controller开始: {}，参数：{}",pjp.getSignature(),pjp.getArgs());
            GeneralResponse = (GeneralResponse<?>) pjp.proceed(pjp.getArgs());
            log.info("执行Controller结束: {}，返回值：{} ", pjp.getSignature(),GeneralResponse.toString());
        } catch (Throwable throwable) {
            GeneralResponse = handleException(pjp, throwable);
        }

        return GeneralResponse;
    }

    private GeneralResponse handleException(ProceedingJoinPoint pjp, Throwable e) {
        GeneralResponse generalResponse = null;
        if(e.getClass().isAssignableFrom(MessageCenterException.class) ){
            MessageCenterException messageCenterException = (MessageCenterException)e;
            log.error("MessageCenterException{方法：" + pjp.getSignature().toShortString() + "， 参数：" + pjp.getArgs() + ",异常：" + messageCenterException.getException().getMessage() + "}", e);
            generalResponse = messageCenterException.getGeneralResponse();
        } else if (e instanceof RuntimeException) {
            log.error("RuntimeException{方法：" + pjp.getSignature().toShortString() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
            generalResponse = new GeneralResponse("1","错误","错误",null);
        } else {
            log.error("异常{方法：" + pjp.getSignature().toShortString() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
            generalResponse = new GeneralResponse("1","错误","错误",null);
        }

        return generalResponse;
    }
}

