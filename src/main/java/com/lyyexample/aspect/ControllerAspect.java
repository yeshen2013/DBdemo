package com.lyyexample.aspect;

import com.alibaba.fastjson.JSON;
import com.lyyexample.common.ResponseModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liuyangyang on 2018/4/16.
 */
@Aspect
@Component
public class ControllerAspect {

    private static Logger logger = LogManager.getLogger(ControllerAspect.class);

    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public Object aroundGetMethod(ProceedingJoinPoint jp) throws Throwable {
        return process(jp);
    }

    @Around("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public Object aroundPostMethod(ProceedingJoinPoint jp) throws Throwable {
        return process(jp);
    }

    private Object process(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String URL = request.getRequestURL().toString();
        String URI = request.getRequestURI();
        String method = request.getMethod();
        String IP = request.getRemoteAddr();
        String user = request.getRequestedSessionId();
        logger.info(IP+"\t"+user+"\t"+method+"\t"+URI+"\n with inputs"+ JSON.toJSONString(jp.getArgs()));
        Object obj = jp.proceed();
        long end = System.currentTimeMillis();
        long time = end - start;
        if(obj != null && obj instanceof ResponseModel){
            ResponseModel<?> res = (ResponseModel<?>) obj;
            logger.info("result code:"+res.getRetCode()+"\t result message:"+res.getRetMsg()+"\t use "+time+"ms");
        }
        return obj;
    }

}
