package com.capgemini.lenscart.service;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.lenscart.daoreprository.RegistrationRepository;
import com.capgemini.lenscart.exception.InvalidContactNoException;
import com.capgemini.lenscart.exception.InvalidEmailIdException;
import com.capgemini.lenscart.exception.NoDuplicateEmailIdException;
import com.capgemini.lenscart.model.Login;
import com.capgemini.lenscart.model.Register;

@Service
public class CustomerNewRegistrationService {
	@Autowired
	RegistrationRepository registrationRepository;

	// checking no duplicate emailId and register new user
	public void registration(Register register) throws NoDuplicateEmailIdException,InvalidEmailIdException,InvalidContactNoException{
		System.out.println("create new registration");
		System.out.println("emailid " + register.getEmailId());
		String reg = register.getEmailId();
		
		 String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";	   
	     boolean result = reg.matches(regex);
	      if(result) {
	    	  System.out.println("emailid is correct patteren");
	      }
	      else {
				throw new InvalidEmailIdException( register.getEmailId() + " is not valid");

	      }
	      
	      
	      Long phoneNo=register.getContactNo();
	      String str = Long.toString(phoneNo);
	      String phonereg = "^\\d{10}$";
	      boolean result1 = str.matches(phonereg);
	      if(result1) {
	    	  System.out.println("contact is correct patteren");
	      }
	      else {
				
				throw new InvalidContactNoException(+ register.getContactNo() + " this number is not contain 10 digit  ");

	      }
		
		if (register != null) {
			System.out.println("register is not null");
			Register RE = registrationRepository.findByEmailId(reg);

			if (RE != null) {
				System.out.println("re is not null");
				throw new NoDuplicateEmailIdException("Email with " + register.getEmailId() + " already Exist");
			}
			
			else {
				registrationRepository.save(register);
				}
		}

	}

	
	public boolean login(Register register) {
		System.out.println("checking emailId and password ");
	String emailId=register.getEmailId();
	String password= register.getPassword();
	Register register1 =registrationRepository.findByEmailIdAndPassword(emailId,password);
	  
	if(register1!=null) {
		
			System.out.println("welcome");
			return true;
		}
		else {
			System.out.println("wrong");
			return false;
		}
	


	}
}










	
	

