package com.ff.util.cache;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Inherited
@Documented
public @interface RCache {
    //唯一标识 建议 类名+方法名，默认为""
    String name() default "";
    //过期时间，单位：秒
    int expireTime() default 50;
}
