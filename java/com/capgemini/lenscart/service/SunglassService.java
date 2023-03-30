package com.capgemini.lenscart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lenscart.daoreprository.AdminJpaRepositorySunglass;
import com.capgemini.lenscart.model.Sunglass;

@Service
public class SunglassService {
	@Autowired
	AdminJpaRepositorySunglass adminJpaRepositorySunglass;

	// getting all list of sunglass
	public List<Sunglass> getSunglass() {
		return adminJpaRepositorySunglass.findAll();
	}

	// adding sunglass
	public Sunglass addSunglass(Sunglass sunglass) {
		return adminJpaRepositorySunglass.save(sunglass);
	}

	// update sunglass
	public Sunglass updateSunglass(Sunglass sunglass) {
		return adminJpaRepositorySunglass.saveAndFlush(sunglass);
	}

	// delete sunglass
	public List<Sunglass> deleteSunglass(int sunglassId) {
		adminJpaRepositorySunglass.deleteById(sunglassId);
		return adminJpaRepositorySunglass.findAll();
	}
	public Optional<Sunglass> getSunglassById(int id) {
        Optional<Sunglass> sunglass =adminJpaRepositorySunglass.findById(id);
        return sunglass;

        }

}
