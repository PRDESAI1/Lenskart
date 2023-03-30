package com.capgemini.lenscart.daoreprository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lenscart.model.Carts;
import com.capgemini.lenscart.model.CreditPayement;
import com.capgemini.lenscart.model.DebitPayement;
@Repository
public interface CreditRepository extends JpaRepository<CreditPayement,Integer>{
	Optional<CreditPayement> findByCardNum(String cardNum);
	

	
}
