package com.zmx.estest.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by dlm on 2016/4/18.
 */
@Retention(RetentionPolicy.RUNTIME)
// 可以注解在字段，方法，类上
@Target({ ElementType.FIELD, ElementType.METHOD,ElementType.TYPE })
public @interface JsonIgnore {
    //默认注解了就是过滤
    boolean Value() default true;
}
