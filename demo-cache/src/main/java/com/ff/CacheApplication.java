package com.ff;

import com.ff.util.cache.RCacheEvict;
import com.ff.util.cache.RCacheable;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/test")
@Slf4j
public class CacheApplication{
	public static void main(String[] args) {
		SpringApplication.run(CacheApplication.class, args);
		log.info("启动了...");
	}
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return new HikariDataSource();
	}

	@RequestMapping("/cacheable")
	@RCacheable(name = "cache",expireTime = 600)
	public List<Object> test(){
	    log.info("---------------------");
		List<Object> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add(i);
		}
		return list;
	}
	@RequestMapping("/cacheevict")
	@RCacheEvict(name = "cache")
	public void test1(){
	    log.info("---------------------");
	}

}
