package com.example.demo.aop;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author by HZL
 * @date 2019/12/16 20:34
 * @description
 */

@Component
@Aspect
public class WebControllerAop {
    @Pointcut("execution(* com.example.demo..*.do*(..))") //pointcut表达式
    public void executeService(){}//point签名

    @Before("executeService()")
    public void doBeforeAdvice(JoinPoint joinPoint){
        //获取RequestAttributes
        RequestAttributes requestAttributes= RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request=(HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        Enumeration<String> enumeration=request.getParameterNames();
        Map<String,String> parameterMap= Maps.newHashMap();
        while (enumeration.hasMoreElements()){
            String paramname=enumeration.nextElement();
            parameterMap.put(paramname,request.getParameter(paramname));
        }
        String str= JSON.toJSONString(parameterMap);
        System.out.println("请求的参数JSON格式为：" + str);
    }
}
