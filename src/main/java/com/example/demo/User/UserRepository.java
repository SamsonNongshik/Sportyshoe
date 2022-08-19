package com.example.demo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select user from User user where user.uname=?1")
	public User findByUser(String uname);
	
	
	@Query("select user from User user where user.upassword=?1")
	public User findbyPwd(String upassword);

}
