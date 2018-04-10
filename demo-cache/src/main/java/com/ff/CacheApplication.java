package com.ff;

import com.alibaba.fastjson.JSON;
import com.ff.util.cache.RCache;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@EnableCaching
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

	@RCache(name = "332")
	@RequestMapping("/cache")
	public String test(){
		List<Object> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add(i);
		}
		return JSON.toJSONString(list);
	}

}
