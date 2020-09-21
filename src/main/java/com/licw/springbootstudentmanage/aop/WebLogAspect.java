package com.licw.springbootstudentmanage.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class WebLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.licw.springbootstudentmanage.service.*.*(..))")
    public void webLog(){
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        logger.info("================请求内容=================");
        logger.info("请求IP:{}",request.getRemoteAddr());
        logger.info("请求URL:{}",request.getRequestURL().toString());
        logger.info("请求方法:{}.{}",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
        logger.info("请求参数:{}",Arrays.toString(joinPoint.getArgs() ) );

    }

    @After("webLog()")
    public void doAfter(){

    }

    @AfterReturning(value = "webLog()",returning = "result")
    public void doAfterReturning(Object result){
        logger.info("============返回内容==========");
        logger.info("返回结果:{}",result);
    }

}
