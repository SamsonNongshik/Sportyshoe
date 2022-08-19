package com.example.demo.Product;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ShoeDao {

	@Autowired
	shoeRepository repo;
	
	public Shoes insert(Shoes s)
	{
		return repo.save(s);
	}
	
	public List<Shoes> getall()
	{
		return repo.findAll();
	}
	
	public Shoes update(Shoes s)
	{
		Shoes s1= repo.findById(s.getSid()).orElse(null);
		s1.setScat(s.getScat());
		s1.setSbrand(s.getSbrand());
		s1.setSquqntity(s.getSquqntity());
		s1.setSdesc(s.getSdesc());
		s1.setSprice(s.getSprice());
		Shoes s2=repo.save(s1);
		return s2;
	}
	public void delete(int sid)
	{
		repo.deleteById(sid);
	}
	
	public List<Shoes> getBybrand(String sbrand)
	{
		return  repo.findBybrand(sbrand);
	}
	public List<Shoes> getByCategory(String scat)
	{
		return  repo.findByCategory(scat);
	}
	
	
}
