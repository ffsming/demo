package com.ff;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@SpringBootApplication
@RestController()
@RequestMapping("/test")
@Slf4j
public class DataSourceApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(DataSourceApplication.class, args);
		log.info("DataSourceApplication服务运行中...");
	}

}
