package com.ff.util.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.*;

@Configuration
@Component
public class JedisClient {

	@Value("${spring.redis.host}")
	private String host;
	@Value("${spring.redis.port}")
	private Integer port;
	@Value("${spring.redis.jedis.timeout}")
	private Integer timeOut;
	@Value("${spring.redis.password}")
	private String password;
	@Value("${spring.redis.jedis.pool.max-idle}")
	private Integer maxIdle;
	@Value("${spring.redis.jedis.max-wait}")
	private Integer maxWait;

	private JedisPool pool;

	private Integer db = 0;

	/**
	 * 获取Jedis对象
	 *
	 * @return
	 */
	public Jedis getJedis() {
		Jedis jedis = pool.getResource();
		jedis.select(db);
		return jedis;
	}
	@Bean
	public JedisPool redisPoolFactory(){
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWait);
		pool = new JedisPool(jedisPoolConfig ,host,port,timeOut,password);
		return  pool;
	}

	/**
	 * 放回Jedis对象
	 * 
	 * @param jedis
	 */
	public void returnResourceObject(Jedis jedis) {
		pool.returnResourceObject(jedis);
	}



}
