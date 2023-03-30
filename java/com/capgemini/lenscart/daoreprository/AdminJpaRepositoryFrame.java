package com.capgemini.lenscart.daoreprository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lenscart.model.Frame;
@Repository
public interface AdminJpaRepositoryFrame extends JpaRepository<Frame,Integer>{

}
