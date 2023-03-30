package com.capgemini.lenscart.daoreprository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lenscart.model.Login;
import com.capgemini.lenscart.model.Register;
@Repository
public interface AdminRepository extends JpaRepository<Login, Integer>{
	public Login findByEmailIdAndPassword(String emailId,String password);
	public Register findByEmailId(String emailId);
}
