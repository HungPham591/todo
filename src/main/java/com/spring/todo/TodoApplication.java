package com.spring.todo;

import com.spring.todo.component.filter.RequestResponseLoggingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.net.InetAddress;

@SpringBootApplication
//@EnableJpaRepositories
public class TodoApplication {
	private final static Logger logger = LoggerFactory.getLogger(TodoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
		logger.info("===> Application is running !!!");
	}

}
