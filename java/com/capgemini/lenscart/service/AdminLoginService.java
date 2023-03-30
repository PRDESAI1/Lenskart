package com.capgemini.lenscart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lenscart.daoreprository.AdminRepository;
import com.capgemini.lenscart.exception.NoDuplicateEmailIdException;
import com.capgemini.lenscart.exception.WrongLoginException;
import com.capgemini.lenscart.model.Login;
import com.capgemini.lenscart.model.Register;
@Service
public class AdminLoginService {
	@Autowired
	AdminRepository adminRepository ;

//	public String adminlogin(String emailId, String password) throws WrongLoginException {
//		
//		Login e=adminRepository.findByEmailIdAndPassword(emailId, password);
//		
//		System.out.println(e);
//		if (e !=null) {
//			return "welcome";
//		}else {
//			throw new WrongLoginException("your email id or password is wrong");
//
//		}
//		
//	}
	public String adminLogin(Login login) throws WrongLoginException {
		System.out.println("checking emailId and password ");
	String emailId=login.getEmailId();
	String password= login.getPassword();
	Login log =adminRepository.findByEmailIdAndPassword(emailId,password);
	  
	if(log!=null) {
		
			return "welcome admin";
		}
		else {
			throw new WrongLoginException("your email id or password is wrong");

		}

	}
	
	

}
