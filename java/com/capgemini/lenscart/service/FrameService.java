package com.capgemini.lenscart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lenscart.daoreprository.AdminJpaRepositoryFrame;
import com.capgemini.lenscart.exception.PriceNegativeException;
import com.capgemini.lenscart.model.Frame;


@Service
public class FrameService {
	@Autowired // autowire enables you to inject the object dependency implicitly
	AdminJpaRepositoryFrame adminJpaRepoFrame;

	// getting all list of frames
	public List<Frame> getFrame() {
		
		
		return adminJpaRepoFrame.findAll();
	}

	// adding frame
	public Frame addFrame(Frame frame) throws PriceNegativeException {
		if(frame.getPrice()<=0) {
			throw new PriceNegativeException("price can not be negative");
			}else {
		return adminJpaRepoFrame.save(frame);
	}
	}
   //update frame
	public Frame updateFrame(Frame frame) {
		return adminJpaRepoFrame.saveAndFlush(frame);
	}

    //delete frame
	public List<Frame> deleteFrame(int frameId) {
		adminJpaRepoFrame.deleteById(frameId);
		return adminJpaRepoFrame.findAll();
	}
	
	public Optional<Frame> findFrameById(int frameId) {
        Optional<Frame> frame =adminJpaRepoFrame.findById(frameId);
        return frame;
    }

}
