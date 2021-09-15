package com.bridgelabz.app.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements IGreetingService{

	@Override
	public String showUserMsg(String fName, String lName) {
//		checking for empty name
		if(fName.isEmpty() && lName.isEmpty()) {
			return "Hello World";
		}else {
			return "hello "+fName+" "+lName;
		}
		
	}






}
