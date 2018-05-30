package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@SpringBootApplication
public class BasicApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BasicApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
	}
	
	@Autowired
	private CounterService counterService;
	
	// 监听/hello 并记录访问hello的次数
	@Bean
	public ApplicationListener<ApplicationEvent> helloListener() {
		final String HELLO_URL = "/hello";

		return (ApplicationEvent event) -> {
			if (event instanceof ServletRequestHandledEvent) {
				ServletRequestHandledEvent e = (ServletRequestHandledEvent) event;
				if (e.getRequestUrl().equals(HELLO_URL))
					counterService.increment("hello.hits");
			}
		};
	}
	
	//随机数，随机生成
		@Bean
		public HealthIndicator myHealth() {
			return () -> {	
				Double a=Math.random()*2;
				if(a>1) {
					return Health.up().build();
				}else {
					return Health.down().withDetail("Error Code", 404).build();
				}				
			};
		}
	
}
