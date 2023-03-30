package com.capgemini.lenscart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lenscart.daoreprository.DebitRepository;
import com.capgemini.lenscart.exception.CardIsPresentException;
import com.capgemini.lenscart.exception.InvalidCardNumberException;
import com.capgemini.lenscart.model.DebitPayement;

@Service
public class DebitService {
	 @Autowired
	  DebitRepository debitRepository;

	    public Optional<DebitPayement> checkAndSaveDebitCardDetail(DebitPayement debit) throws CardIsPresentException,InvalidCardNumberException{
	        String cardNum = debit.getCardNum();
	        Optional<DebitPayement> cartResult = debitRepository.findByCardNum(cardNum);
	        System.out.println(cardNum.length());
	        if(cardNum.length()!=16) {
	            throw new InvalidCardNumberException("Invalid card number,Insert carefully");
	        }
	        else if(cartResult.isEmpty()) {
	            debitRepository.save(debit);
	            return cartResult;
	        }
	        else {
	            throw new CardIsPresentException("Save Alredy");
	        }
	    }
}
