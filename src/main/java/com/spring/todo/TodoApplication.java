package com.spring.todo;

import com.spring.todo.component.filter.RequestResponseLoggingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
//@EnableJpaRepositories
public class TodoApplication {
	private final static Logger logger = LoggerFactory.getLogger(TodoApplication.class);

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication app = new SpringApplication(TodoApplication.class);
		Map<String, Object> defProperties = new HashMap<>();
//		defProperties.put(SPRING_PROFILE_DEFAULT, EnviromentConstant.SPRING_PROFILE_DEVELOPMENT);
//		app.setDefaultProperties(defProperties);
		Environment env = app.run(args).getEnvironment();
		String protocol = "http";
		logger.info(
				"\n----------------------------------------------------------\n\t"
						+ "Application '{}' is running! Access URLs:\n\t" + "Local: \t\t{}://localhost:{}\n\t"
						+ "External: \t{}://{}:{}\n\t"
						+ "Swagger: \thttp://localhost:8080/swagger-ui/\n\t"
						+ "Profile(s): {}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"), protocol, env.getProperty("server.port"), protocol,
				InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"), env.getActiveProfiles());
	}

}
