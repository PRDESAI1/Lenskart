package com.capgemini.lenscart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lenscart.daoreprository.CreditRepository;
import com.capgemini.lenscart.daoreprository.DebitRepository;
import com.capgemini.lenscart.exception.CardIsPresentException;
import com.capgemini.lenscart.exception.InvalidCardNumberException;
import com.capgemini.lenscart.model.CreditPayement;

@Service
public class CreaditService {
	@Autowired
	  CreditRepository creditRepository;
	
	public Optional<CreditPayement> checkAndSaveDebitCardDetail(CreditPayement credit) throws CardIsPresentException,InvalidCardNumberException{
        String cardNum = credit.getCardNum();
        Optional<CreditPayement> cartResult = creditRepository.findByCardNum(cardNum);
        //System.out.println(cardNum.length());
        if(cardNum.length()!=16) {
            throw new InvalidCardNumberException("Invalid card number,Insert carefully");
        }
        else if(cartResult.isEmpty()) {
            creditRepository.save(credit);
            return cartResult;
        }
        else {
            throw new CardIsPresentException("Save Alredy");
        }
    }
}
