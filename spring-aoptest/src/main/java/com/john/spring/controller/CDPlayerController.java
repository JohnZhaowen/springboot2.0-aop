package com.john.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.john.spring.aop.PlayAop;
import com.john.spring.controller.service.DiskService;
import com.john.spring.introduce.Encoreable;

@RestController
public class CDPlayerController {
	
	@Autowired
	private DiskService service;
	
	@RequestMapping("/play")
	public String play(int trace) {
		
		String play = service.play(trace);
		
		System.out.println("songs: " + play + "played: " + PlayAop.getCount(trace) + " times.");
		
		return play;
	}
	@RequestMapping("/encoreable")
	public String encoreable() {
		
		Encoreable encore = (Encoreable)service;
		encore.performEncore();
		return "xxx";
	}
}
