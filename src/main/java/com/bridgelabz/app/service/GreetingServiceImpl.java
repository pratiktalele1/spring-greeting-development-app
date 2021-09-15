package com.bridgelabz.app.service;

import java.util.List;
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
			user.setMessage("hello "+fName+" "+lName+"World");
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

//	get data by id method
	@Override
	public String getDataById(int id) {
		String msg = "";
		List<User> greetingMessages = greetingRepository.findAll();
		for (User greetingMessage : greetingMessages) {
			if (greetingMessage.getId() == id) {
				msg = greetingMessage.getMessage();
			}
		}
		return msg;
	}

//	get all data method
	@Override
	public List<User> getAllData() {
		return greetingRepository.findAll();
	}

//	msg update by id method
	@Override
	public User updateDataById(User user, int id) {
		List<User> greetingMessages = greetingRepository.findAll();
		User getObj=greetingMessages.stream().filter(e->e.getId()==id).findFirst().get();
		getObj.setMessage(user.getMessage());
		greetingRepository.save(getObj);
		return getObj;
	}

//	msg delete by id method
	@Override
	public String deleteDataById(int id) {
		List<User> greetingMessages = greetingRepository.findAll();
		User getObj=greetingMessages.stream().filter(e->e.getId()==id).findFirst().get();
		greetingRepository.delete(getObj);
		return "id ->"+id+"is deleted";
	}

	






}
