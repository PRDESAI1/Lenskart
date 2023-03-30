package com.capgemini.lenscart.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.lenscart.daoreprository.CartRepository;
import com.capgemini.lenscart.model.Carts;


@Service
public class CartService {
	@Autowired
	CartRepository cartRepository;

//	// add product into cart
//	public Carts addToCart(Carts cart) {
//		return cartRepository.save(cart);
//	}
//
//	// delete product from cart
//	public List<Carts> deleteFromCart(int id) {
//		cartRepository.deleteById(id);
//		return cartRepository.findAll();
//	}
//
//	// update into cart
//	public Carts updateInCart(Carts carts) {
//		return cartRepository.saveAndFlush(carts);
//	}
//	
	public Carts addToCart(Carts cart) {
		return cartRepository.save(cart);
	}


}
