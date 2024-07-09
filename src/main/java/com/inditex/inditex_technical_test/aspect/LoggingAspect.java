package com.inditex.inditex_technical_test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* com.inditex.inditex_technical_test.controller..*.*(..))")
    private void publicMethodsForLogging() {
    }

    @Around(value = "publicMethodsForLogging()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String arrayStrings = Arrays.toString(joinPoint.getArgs());
        String methodName = joinPoint.getSignature().getName();
        logger.info(">> {}() - {}", methodName, arrayStrings);
        Object result = joinPoint.proceed();
        logger.info("<< {}() - {}", methodName, result);
        return result;
    }

}
