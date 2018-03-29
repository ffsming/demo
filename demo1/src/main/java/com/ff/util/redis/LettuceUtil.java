package com.ff.util.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LettuceUtil {

    private RedisClient client;

    @Autowired
    public void setRedisClient(RedisClient client) {
        this.client = client;
    }

    public String set(String key, String value){
        StatefulRedisConnection<String, String> connection = client.connect();// 连接
        String str = "";
        try{
            RedisCommands redis = connection.sync();
            str = redis.set(key,value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return str;
    }
    public String get(String key){
        StatefulRedisConnection<String, String> connection = client.connect();// 连接
        String str = "";
        try{
            RedisAsyncCommands<String, String> redis = connection.async();// 异步操作
            RedisFuture<String> future = redis.get(key);
            str = future.get();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return str;
    }

}
