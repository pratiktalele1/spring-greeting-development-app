package com.bridgelabz.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.app.model.User;
import com.bridgelabz.app.service.IGreetingService;

@RestController
@RequestMapping("/greet")
public class GreetingController {
	
	@Autowired
	private IGreetingService greetingService;
	
//	creating list for storage
	private List<User> list=new ArrayList<User>();
	
//	creating atomiclong for id generation 
	private AtomicLong atomicLong=new AtomicLong();
	
//	creating method to get all user
	@GetMapping
	public List<User> getAll() {
		return list;
	}
	
//	creating method to get user by id
	@GetMapping("/{id}")
	public String getById(@PathVariable int id) {
		User user=list.stream().filter(e->e.getId()==id).findFirst().get();
		return "hello "+user.getName();
	}
	
//	creating method to create user
	@PostMapping
	public String create(@RequestBody User user) {
		user.setId(atomicLong.incrementAndGet());
		list.add(user);
		return "hello "+user.getName()+" added";
	}
	
//	creating method to update user by id
	@PutMapping("/{id}")
	public String putById(@RequestBody User user,@PathVariable int id) {
		User show=list.get(id-1);
		show.setName(user.getName());
		return "hello "+show.getName();
	}
	
//	method to delete user by id
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id) {
		list.remove(id-1);
		return "delted Id ->"+id;
	}
	
//	method for greeting by first name or last name or nothing 
//	also storing message to data base
	@GetMapping("/msg")
	public String showMsg(@RequestParam(value = "fName",defaultValue = "") String fName,@RequestParam(value = "lName",defaultValue = "") String lName) {
		return greetingService.showUserMsg(fName,lName);
	}
	
//	method to get greet msg by id
	@GetMapping("/msg/{id}")
	public String getDataById(@PathVariable int id){
		return greetingService.getDataById(id);
	}
	
//	method to get all greet msg
	@GetMapping("/msg/all")
	public ResponseEntity<List<User>> getAllData(){
		return new ResponseEntity<>(greetingService.getAllData(),HttpStatus.OK);
	}
	
//	method to update greet msg by id
	@PutMapping("/msg/{id}")
	public ResponseEntity<User> updateGreetMsgById(@PathVariable int id,@RequestBody User user){
		return new ResponseEntity<>(greetingService.updateDataById(user,id),HttpStatus.OK);
	}
	
//	method to delete greet msg by id
	@DeleteMapping("/msg/delete/{id}")
	public String deleteGreetingById(@PathVariable int id) {
		return greetingService.deleteDataById(id);
	}
	
}
