 package com.example.demo.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface shoeRepository  extends JpaRepository<Shoes, Integer>{

	
	@Query("select shoe from Shoes shoe where shoe.sbrand=?1")
	public List<Shoes> findBybrand(String sbrand);

    @Query("select shoe from Shoes shoe where shoe.scat=?1")
    public List<Shoes> findByCategory(String scat);
    
    
}
