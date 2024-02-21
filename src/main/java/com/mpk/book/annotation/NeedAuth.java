package com.mpk.book.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 登录认证注解
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value= {ElementType.METHOD, ElementType.FIELD})
public @interface NeedAuth {
    public boolean needAuth() default false;
    public String[] needRole() default {};
}
