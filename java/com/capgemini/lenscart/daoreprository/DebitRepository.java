package com.capgemini.lenscart.daoreprository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lenscart.model.DebitPayement;
@Repository
public interface DebitRepository extends JpaRepository<DebitPayement,Integer> {
	
	Optional<DebitPayement> findByCardNum(String cardNum);
}
