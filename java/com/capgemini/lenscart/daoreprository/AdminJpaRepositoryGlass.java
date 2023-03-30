package com.capgemini.lenscart.daoreprository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lenscart.model.Glass;


@Repository
public interface AdminJpaRepositoryGlass extends JpaRepository<Glass,Integer>{
	

	}

