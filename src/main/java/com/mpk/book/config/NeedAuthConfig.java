package com.mpk.book.config;

import cn.dev33.satoken.stp.StpUtil;
import com.mpk.book.annotation.NeedAuth;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@Aspect
@Component
public class NeedAuthConfig {

    @Pointcut("@annotation(com.mpk.book.annotation.NeedAuth)")
    public void needAuth(){
    }

    @Before("needAuth()")
    public void beforeRequestInDirect(JoinPoint point) throws IOException {
        HttpServletResponse response =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.setContentType("application/json;charset=utf-8");

        MethodSignature sign = (MethodSignature) point.getSignature();
        Method method = sign.getMethod();
        NeedAuth annotation = method.getAnnotation(NeedAuth.class);

        Object o = StpUtil.getLoginIdDefaultNull();
        if (o == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized
            response.getOutputStream().write("用户未登录".getBytes());
            response.getOutputStream().close();
        } else {
            if (annotation.needAuth()) {
                String[] needRole = annotation.needRole();
                if (needRole != null && needRole.length > 0 && !StpUtil.hasRole(needRole[0])) {
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN); // 403 Forbidden
                    response.getOutputStream().write("用户非管理员".getBytes());
                    response.getOutputStream().close();
                }
            }
        }
    }
}