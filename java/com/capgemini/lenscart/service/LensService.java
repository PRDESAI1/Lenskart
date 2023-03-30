package com.capgemini.lenscart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.lenscart.daoreprository.AdminJpaRepositoryLens;
import com.capgemini.lenscart.model.Lens;

@Service
public class LensService {
	@Autowired
	AdminJpaRepositoryLens adminJpaRepositoryLens;

	// getting all list of lens
	public List<Lens> getLens() {
		return adminJpaRepositoryLens.findAll();
	}

	// delete lens
	public List<Lens> deleteLens(int lensId) {
		adminJpaRepositoryLens.deleteById(lensId);
		return adminJpaRepositoryLens.findAll();
	}

	// update lens
	public Lens updateLens(Lens lens) {
		return adminJpaRepositoryLens.saveAndFlush(lens);
	}

	// adding lens
	public Lens addLens(Lens lens) {
		return adminJpaRepositoryLens.save(lens);
	}

	public Optional<Lens> getLensById(int id) {
		 Optional<Lens> lens=adminJpaRepositoryLens.findById(id);
		return lens;
	}

}
