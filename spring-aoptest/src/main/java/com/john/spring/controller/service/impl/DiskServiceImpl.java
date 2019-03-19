package com.john.spring.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.john.spring.controller.service.DiskService;

@Service
public class DiskServiceImpl implements DiskService {
	
	private static List<String> songs = new ArrayList<String>();
	
	static {
		songs.add("hello1");
		songs.add("hello2");
		songs.add("hello3");
		songs.add("hello4");
		songs.add("hello5");
		songs.add("hello6");
		songs.add("hello7");
		songs.add("hello8");
		songs.add("hello9");
		songs.add("hello10");
	}

	@Override
	public String play(int trace) {
		return songs.get(trace);
	}

}
