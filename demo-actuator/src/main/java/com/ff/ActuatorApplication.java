package com.ff;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class ActuatorApplication{
	public static void main(String[] args) {
		SpringApplication.run(ActuatorApplication.class, args);
		log.info("启动了...");
	}
	@RequestMapping("/test")
	public String test(){
		return "test";
	}

}
