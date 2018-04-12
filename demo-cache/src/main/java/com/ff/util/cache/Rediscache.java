package com.ff.util.cache;


import com.alibaba.fastjson.JSON;
import com.ff.util.redis.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Object requestCacheable(ProceedingJoinPoint proceedingJoinPoint , RCacheable cache) throws Throwable {
        String key = "cache_"+cache.name();
        Signature signature =  proceedingJoinPoint.getSignature();
        Class returnType = ((MethodSignature) signature).getReturnType();
        //从缓存取值
        Object op =  JSON.parseObject(jedisUtil.jedisGet(key),returnType);
        if(op != null){
            log.info("redis取值==" + op);
            return op;
        }
        //缓存没有则执行方法并更新缓存
        try {
            Object object = proceedingJoinPoint.proceed();
            log.info(object.toString());
            String flag = jedisUtil.jedisSet(key , JSON.toJSONString(object) , "NX" , "EX" , cache.expireTime());
            if(flag == null || flag.length() == 0){
                jedisUtil.jedisDel(key);
                jedisUtil.jedisSet(key , JSON.toJSONString(object) , "NX" , "EX" , cache.expireTime());
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error(cache.name() + " redis锁异常了");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.error(cache.name() + " redis锁异常了");
        }
        return null;
    }
    @Around("@annotation(evict)")
    public Object requestCacheEvict(ProceedingJoinPoint proceedingJoinPoint , RCacheEvict evict) throws Throwable {
        String key = "cache_"+evict.name();
        try {
            proceedingJoinPoint.proceed();
            jedisUtil.jedisDel(key);
        }catch (Exception e){
            e.printStackTrace();
            log.error(evict.name() + " redis锁异常了");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.error(evict.name() + " redis锁异常了");
        }
        return null;
    }
}
