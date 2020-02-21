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

        Msg<?> Msg;
        try {
            log.info("执行Controller开始: {}，参数：{}",pjp.getSignature(),pjp.getArgs());
            Msg = (Msg<?>) pjp.proceed(pjp.getArgs());
            log.info("执行Controller结束: {}，返回值：{} ", pjp.getSignature(), Msg.toString());
        } catch (Throwable throwable) {
            Msg = handleException(pjp, throwable);
        }

        return Msg;
    }

    private Msg handleException(ProceedingJoinPoint pjp, Throwable e) {
        Msg msg = null;
        if(e.getClass().isAssignableFrom(MessageCenterException.class) ){
            MessageCenterException messageCenterException = (MessageCenterException)e;
            log.error("MessageCenterException{方法：" + pjp.getSignature().toShortString() + "， 参数：" + pjp.getArgs() + ",异常：" + messageCenterException.getException().getMessage() + "}", e);
            msg = messageCenterException.getMsg();
        } else if (e instanceof RuntimeException) {
            log.error("RuntimeException{方法：" + pjp.getSignature().toShortString() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
            msg = new Msg("1","错误","错误",null);
        } else {
            log.error("异常{方法：" + pjp.getSignature().toShortString() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
            msg = new Msg("1","错误","错误",null);
        }

        return msg;
    }
}

