package com.john.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import com.john.spring.introduce.Encoreable;
import com.john.spring.introduce.EncoreableImpl;

@Aspect
@Component
public class EncoreableIntroducer {
	@DeclareParents(value="com.john.spring.controller.service.impl.DiskServiceImpl", defaultImpl=EncoreableImpl.class)
	public Encoreable encoreable;
}
