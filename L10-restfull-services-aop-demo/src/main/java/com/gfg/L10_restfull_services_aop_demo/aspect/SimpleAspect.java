package com.gfg.L10_restfull_services_aop_demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

    private Logger LOGGER = LoggerFactory.getLogger(SimpleAspect.class);

    @Before("execution(* com.gfg.L10_restfull_services_aop_demo.service.ProductService.getById(...))")
    public void beforeMethod(){
        LOGGER.info("Executing before actual method");
    }

    @Around("@annotation(com.gfg.L10_restfull_services_aop_demo.aspect.LogExecutionTime)")
    public Object beforeAnnotatedMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // start time
        long start = System.currentTimeMillis();
        // call actual method
        Object result = proceedingJoinPoint.proceed();
        // end time
        long end = System.currentTimeMillis();
        LOGGER.info("Executing {} time: {} ", proceedingJoinPoint.getTarget(), end-start);
        return result;
    }

}
