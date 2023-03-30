package com.capgemini.lenscart.daoreprository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lenscart.model.Register;
@Repository
public interface RegistrationRepository extends JpaRepository<Register, Integer> {
	

		 public Register findByEmailId(String emailId);
		 public Register findByEmailIdAndPassword(String emailId,String password);
		
			
	}

