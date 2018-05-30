package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class hello {
	@RequestMapping(value="/xyz")
	public String taozhuan() {
		return "hi";
	}
}
