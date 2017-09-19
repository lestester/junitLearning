package com.teng.liu.core;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface Options {

    String[] files() default "";

    String[] services() default "service.xml";

    String[] tags() default "*";

}
