package com.ff.util.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

/**
 * @author sunming
 * @date 2018/04/10
 */
@Component
@Slf4j
public class JedisUtil {

	/**
	 * 日志类.
	 */

	@Autowired
	private JedisClient jedisClient;

	public String jedisGet(String key) {
		String obj = null;
		// 标准部分开始
		Jedis jedis = jedisClient.getJedis();
		try {
			// 取出
			obj = jedis.get(key);
		} catch (Exception e) {
			if (e.getMessage() == null) {
				log.error("redis数据操作工具类-读取异常:参数无效! key:"+key);
			} else {
				log.error("redis数据操作工具类-读取异常:" + e.getMessage());
			}

		} finally {
			// 释放资源
			jedisClient.returnResourceObject(jedis);
		}
		return obj;
	}

	/**
	 * Set the string value as value of the key. The string can't be longer than 1073741824 bytes (1
	 * GB).
	 *
	 * @param key
	 * @param value
	 * @param nxxx  NX|XX, NX -- Only set the key if it does not already exist. XX -- Only set the key
	 *              if it already exist.
	 * @param expx  EX|PX, expire time units: EX = seconds; PX = milliseconds
	 * @return Status code reply
	 */
	public String jedisSet(String key, String value, String nxxx, String expx, long expireTime) {
		String flag = "";
		// 标准部分开始
		Jedis jedis = jedisClient.getJedis();
		try {
			// 存入
			flag = jedis.set(key, value, nxxx, expx, expireTime);
		} catch (Exception e) {
			if (e.getMessage() == null) {
				log.error("redis数据操作工具类-存入异常:参数无效!key:" + key);
			} else {
				log.error("redis数据操作工具类-存入异常:" + e.getMessage());
			}
		} finally {
			// 释放资源
			jedisClient.returnResourceObject(jedis);
		}
		return flag;
	}

	/**
	 * 删除
	 * 
	 * @param key
	 * 
	 */
	public Integer jedisDel(String key) {
		// 标准部分开始
		Jedis jedis = jedisClient.getJedis();
		Long count = 0L;
		try {
			count = jedis.del(key);
		} catch (Exception e) {
			if (e.getMessage() == null) {
				log.error("redis数据操作工具类-存入异常:参数无效!");
			} else {
				log.error("redis数据操作工具类-存入异常:" + e.getMessage());
			}
		} finally {
			// 释放资源
			jedisClient.returnResourceObject(jedis);
		}
		return count.intValue();
	}
	public void batchDel(String key){
		// 标准部分开始
		Jedis jedis = jedisClient.getJedis();

		try {
			Set<String> set = jedis.keys(key +"*");
			Iterator<String> it = set.iterator();
			while(it.hasNext()){
				String keyStr = it.next();
				log.info("删除key==" + keyStr);
				jedis.del(keyStr);
			}
		} catch (Exception e) {
			if (e.getMessage() == null) {
				log.error("redis数据操作工具类-存入异常:参数无效!key:" + key);
			} else {
				log.error("redis数据操作工具类-存入异常:" + e.getMessage());
			}
		} finally {
			// 释放资源
			jedisClient.returnResourceObject(jedis);
		}

	}
}
