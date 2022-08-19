package com.example.demo.Product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Shoes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int sid;
	private String sdesc;
	private String scat;
	private String sbrand;
	private int sprice;
	private int squqntity;
	
	
}
