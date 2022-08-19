package com.example.demo.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdminDao {
@Autowired
AdminRepository repo;

public Admin updatepassword(Admin a)
{
	Admin a1= repo.findByuser(a.getAuser());
	a1.setAuser(a.getAuser());
	a1.setApassword(a.getApassword());
	Admin a2=repo.save(a1);
	return a2;
}
}
