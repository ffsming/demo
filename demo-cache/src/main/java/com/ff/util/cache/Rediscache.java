package com.ff.util.cache;


import com.ff.util.redis.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author
 * @date
 */
@Aspect
@Component
@Slf4j
public class Rediscache {
    @Autowired
    private JedisUtil jedisUtil;
    private static final String OK = "OK";

    @Around("@annotation(cache)")
    public void requestcacheBefore(ProceedingJoinPoint proceedingJoinPoint , RCache cache) throws NoSuchMethodException {

        //获取方法返回值类型
        Object[] args = proceedingJoinPoint.getArgs();
        Class<?>[] paramsCls = new Class<?>[args.length];
        for (int i = 0; i < args.length; ++i) {
            paramsCls[i] = args[i].getClass();
        }
        //获取方法
        Method method = proceedingJoinPoint.getTarget().getClass().getMethod(proceedingJoinPoint.getSignature().getName(), paramsCls);
        //获取返回值类型
        Type t = method.getAnnotatedReturnType().getType();
        System.out.println(t.getTypeName());



        String flag = jedisUtil.jedisSet("cache_"+cache.name() , "1" , "NX" , "EX" , cache.expireTime());
        log.info(cache.name() +"  redis开关状态--"+flag);
        if(StringUtils.isEmpty(flag)){
            return;
        }
        try {
            if(OK.equalsIgnoreCase(flag)){
                Object object = proceedingJoinPoint.proceed();
                log.info(object.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error(cache.name() + " redis锁异常了");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.error(cache.name() + " redis锁异常了");
        }
    }
}
