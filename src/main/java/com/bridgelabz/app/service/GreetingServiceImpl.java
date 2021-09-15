package com.bridgelabz.app.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements IGreetingService{

	@Override
	public String showUserMsg() {
		return "Hello World";
	}

}
