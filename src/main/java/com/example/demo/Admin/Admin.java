package com.example.demo.Admin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Admin {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	
	private int id;
	private String auser;
	private String apassword;
	private String aemail;
}
