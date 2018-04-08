package com.ff;

import com.alibaba.fastjson.JSON;
import com.ff.service.message.MessageDetailService;
import com.ff.timer.CronJob;
import com.ff.timer.SampleJob;
import com.ff.util.redis.LettuceUtil;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@MapperScan("com.ff.dao")
@RestController
@RequestMapping("/test")
@Slf4j
@ServletComponentScan
@EnableCaching
public class Demo1Application  extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Demo1Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
		log.info("启动了...");
	}
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return new HikariDataSource();
	}
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*/*Mapper.xml"));
		return sqlSessionFactoryBean.getObject();
	}


	@Bean
	public JobDetail sampleJobDetail() {
		return JobBuilder.newJob(SampleJob.class).withIdentity("sampleJob").storeDurably().build();
	}

	@Bean
	public SimpleTrigger sampleJobTrigger() {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(2).repeatForever();

		return TriggerBuilder.newTrigger().forJob(sampleJobDetail())
				.withIdentity("sampleTrigger").withSchedule(scheduleBuilder).build();
	}

	@Bean
	public JobDetail cronJobDetail(){
		return JobBuilder.newJob(CronJob.class).withIdentity("cronJob").storeDurably().build();
	}
	@Bean
	public CronTrigger cronTrigger(){
		CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 */1 * * * ?");
//		CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.dailyAtHourAndMinute(7,45);

		return TriggerBuilder.newTrigger().forJob(cronJobDetail()).withIdentity("cronTrigger")
				.withSchedule(cronScheduleBuilder).build();
	}
	@Autowired
	private MessageDetailService service;


	@Autowired
	private LettuceUtil lettuceUtil;
	@Cacheable("11111")
	@RequestMapping("/test")
	public String test(){
		log.info("tee");
		List list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		return JSON.toJSONString(list);
	}

}
