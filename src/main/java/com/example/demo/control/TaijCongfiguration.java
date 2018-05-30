package com.example.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(FooProperties.class)
public class TaijCongfiguration {
	@Autowired
	private FooProperties fooProperties;
	@Bean
	public String toString() {
		System.out.println(fooProperties);
		return fooProperties.toString();
		}
}
