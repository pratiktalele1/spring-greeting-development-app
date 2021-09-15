package com.bridgelabz.app.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.app.model.User;
import com.bridgelabz.app.repository.IGreetingRepository;

@Service
public class GreetingServiceImpl implements IGreetingService{

	private static AtomicLong atomicLong=new AtomicLong();
		
	@Autowired
	private IGreetingRepository greetingRepository;
	
	@Override
	public String showUserMsg(String fName, String lName) {
//		checking for empty name
		
		User user=new User();
		
		if(fName.isEmpty() && lName.isEmpty()) {
//			storing message to repository
			user.setId(atomicLong.incrementAndGet());
			user.setMessage("hello "+fName+" "+lName);
			user.setName(fName+" "+lName);
			greetingRepository.save(user);
			return "Hello World";
		}else
		{	
//			storing message to repository
			user.setId(atomicLong.incrementAndGet());
			user.setMessage("hello "+fName+" "+lName);
			user.setName(fName+" "+lName);
			greetingRepository.save(user);
			return "hello "+fName+" "+lName;
		}
		
	}






}
