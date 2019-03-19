package com.john.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/test1")
	public String test1(String name) {
		System.out.println("test1 proceding..." + name);
		
		int num = 1 / 0;
		return "hello " + name;
	}
}
