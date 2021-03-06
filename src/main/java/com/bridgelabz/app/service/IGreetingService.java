package com.bridgelabz.app.service;

import java.util.List;

import com.bridgelabz.app.model.User;

public interface IGreetingService {

	
	
	String showUserMsg(String fName, String lName);

	String getDataById(int id);

	List<User> getAllData();

	User updateDataById(User user, int id);

	String deleteDataById(int id);



}
