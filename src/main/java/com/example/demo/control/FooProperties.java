package com.example.demo.control;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="foo")
public class FooProperties {
	private String name;
	private int age;
	private boolean graduation;
	private Map<String, String> map;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isGraduation() {
		return graduation;
	}
	public void setGraduation(boolean graduation) {
		this.graduation = graduation;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	@Override
	public String toString() {
		return "FooProperties [name=" + name + ", age=" + age + ", graduation=" + graduation + ", map=" + map + "]";
	}
	
}
