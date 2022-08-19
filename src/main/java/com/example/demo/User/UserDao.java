package com.example.demo.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
 
	@Autowired
	UserRepository repo;
	
	
	public User adduser(User s)
	{
		return repo.save(s);
	}
	
	public List<User> alluser()
	{
		return repo.findAll();
	}
}
