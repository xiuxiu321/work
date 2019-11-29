package com.baizhi.aspect;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//指定注解的生效时机  运行时
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})//指定注解作用范围  方法上
public @interface Log {//自定义 注解类

    String name();//属性
}
