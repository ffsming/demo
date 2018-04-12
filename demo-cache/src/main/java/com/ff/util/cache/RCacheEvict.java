package com.ff.util.cache;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Inherited
@Documented
public @interface RCacheEvict {
    //唯一标识 建议 类名+方法名，默认为""
    String name() default "";
}
