package com.john.spring.introduce;

import org.springframework.stereotype.Component;

@Component
public class EncoreableImpl implements Encoreable {

	@Override
	public void performEncore() {
		System.out.println("performEncore...");

	}

}
