package com.bridgelabz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.app.model.User;
//repository for storing greeting message
public interface IGreetingRepository extends JpaRepository<User, Integer>{

}
