package com.capgemini.lenscart.daoreprository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lenscart.model.Sunglass;

@Repository
public interface AdminJpaRepositorySunglass extends JpaRepository<Sunglass,Integer>{
	
}
