package com.capgemini.lenscart.daoreprository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capgemini.lenscart.model.Lens;

@Repository
	public interface AdminJpaRepositoryLens extends JpaRepository<Lens,Integer> {

		
		
	}

