package com.capgemini.lenscart.daoreprository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lenscart.model.Carts;
@Repository
public interface CartRepository extends JpaRepository<Carts,Integer>{

}
