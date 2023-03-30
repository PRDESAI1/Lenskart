package com.capgemini.lenscart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lenscart.daoreprository.CreditRepository;
import com.capgemini.lenscart.exception.CardIsPresentException;
import com.capgemini.lenscart.exception.InvalidCardNumberException;
import com.capgemini.lenscart.exception.InvalidContactNoException;
import com.capgemini.lenscart.exception.InvalidEmailIdException;
import com.capgemini.lenscart.exception.NoDuplicateEmailIdException;
import com.capgemini.lenscart.exception.WrongLoginException;
import com.capgemini.lenscart.model.Carts;
import com.capgemini.lenscart.model.CreditPayement;
import com.capgemini.lenscart.model.DebitPayement;
import com.capgemini.lenscart.model.Frame;
import com.capgemini.lenscart.model.Glass;
import com.capgemini.lenscart.model.Lens;
import com.capgemini.lenscart.model.Register;
import com.capgemini.lenscart.model.Sunglass;
import com.capgemini.lenscart.service.FrameService;
import com.capgemini.lenscart.service.GlassService;
import com.capgemini.lenscart.service.LensService;
import com.capgemini.lenscart.service.SunglassService;
import com.capgemini.lenscart.service.CartService;
import com.capgemini.lenscart.service.CreaditService;
import com.capgemini.lenscart.service.CustomerNewRegistrationService;
import com.capgemini.lenscart.service.DebitService;

@RestController
@CrossOrigin
@RequestMapping(path = "/customer")
public class CustomerController {

	@Autowired
	FrameService frameService;

	@Autowired
	GlassService glassService;

	@Autowired
	LensService lensService;

	@Autowired
	SunglassService sunglassService;

	@Autowired
	CartService cartService;

	@Autowired
	CustomerNewRegistrationService customerNewRegistrationService;
	@Autowired
    DebitService debitPaymentService;

    @Autowired
    CreaditService creditPaymentService;
	
	/**
	 * 
	 * @return list of all frames 
	 */

	// http://localhost:8086/lenscart/customer/getFrame
	@RequestMapping(path = "/getFrame")
	public List<Frame> getFrame() {
		List<Frame> frameList = frameService.getFrame();
		return frameList;

	}
	/**
	 * 
	 * @return list of all glass
	 */

	// http://localhost:8086/lenscart/customer/getGlass
	@RequestMapping(path = "/getGlass")
	public List<Glass> getGlass() {
		List<Glass> glassList = glassService.getGlass();
		return glassList;

	}
	/**
	 * 
	 * @return list of all lens
	 */

	// http://localhost:8086/lenscart/customer/getLens
	@RequestMapping(path = "/getLens")
	public List<Lens> getLens() {
		List<Lens> lensList = lensService.getLens();
		return lensList;

	}
	/**
	 * 
	 * @return list of all sunglass
	 */

	// http://localhost:8086/lenscart/customer/getSunglass
	@RequestMapping(path = "/getSunglass")
	public List<Sunglass> getSunglass() {
		List<Sunglass> SunglassList = sunglassService.getSunglass();
		return SunglassList;

	}
	/**
	 * Registration for new customer
	 * @param register register object
	 * @return message
	 * @throws NoDuplicateEmailIdException exception for duplicate emailId 
	 * @throws InvalidEmailIdException 
	 * @throws InvalidContactNoException 
	 * @throws NoDuplicateUserId exception for duplicate userId
	 */

	// http://localhost:8086/lenscart/customer/registration
	@PostMapping(value = "/registration", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> registration(@RequestBody Register register) throws NoDuplicateEmailIdException, InvalidEmailIdException, InvalidContactNoException {
		customerNewRegistrationService.registration(register);
		System.out.println("new customer Register in database");
		return ResponseEntity.ok("sucessfull");

	}
	
	/**
	 * login 
	 * @param emailId 
	 * @param password
	 * @return message
	 * @throws WrongLoginException 
	 */
	
	
	//http://localhost:8087/lenscart/customer/login
	@PostMapping(value = "/login")
	public ResponseEntity<String> login(@RequestBody Register register) throws WrongLoginException {
	boolean flag=customerNewRegistrationService.login(register);
	if(flag) {
		return ResponseEntity.ok("welcome to E-Commerce");

	}else {
		throw new WrongLoginException("your email id or password is wrong");

		}
	
}

	/**
	 * adding product into cart
	 * @param cart cart object
	 * @return product in cart
	 */

	//http://localhost:8086/lenscart/customer/addCart
	@PostMapping(value = "/addCart", produces = "application/json")
	public ResponseEntity<Carts> addToCart(@RequestBody Carts cart) {
		
		Carts cart1 = cartService.addToCart(cart);
		return ResponseEntity.ok(cart1);

	}
	//http://localhost:8086/lenscart/customer/paymentWithDebitCard
	    @PostMapping(value = "/paymentWithDebitCard", produces = "application/json")
	    public ResponseEntity<DebitPayement> debitCard(@RequestBody DebitPayement debit) throws CardIsPresentException,InvalidCardNumberException{

	        Optional<DebitPayement> debitResult = debitPaymentService.checkAndSaveDebitCardDetail(debit);
	        return ResponseEntity.ok(debit);
	    }

	    
	    
	 //http://localhost:8086/lenscart/customer/paymentWithCreditCard
	        @PostMapping(value = "/paymentWithCreditCard", produces = "application/json")
	        public ResponseEntity<CreditPayement> CreditCard(@RequestBody CreditPayement credit) throws CardIsPresentException,InvalidCardNumberException{

	            Optional<CreditPayement> creditResult = creditPaymentService.checkAndSaveDebitCardDetail(credit);
	            return ResponseEntity.ok(credit);
	        }

	

}

