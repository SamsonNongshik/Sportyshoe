package com.example.demo.Admin;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	@Query("select admin from Admin admin where admin.auser=?1")
	public Admin findByuser(String auser);
	
	@Query("select admin from Admin admin where admin.apassword=?1")
	public Admin findBypwd(String apassword);
}