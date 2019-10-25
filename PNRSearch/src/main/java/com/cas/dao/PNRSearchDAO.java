package com.cas.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.cas.dto.PnrDTO;

public class PNRSearchDAO   {
	
	@Autowired
	PNRRepository pnrRepo;

	
	public PnrDTO fetchNames(PnrDTO pnr) {	
	PnrDTO dto=	pnrRepo.findAll();
	return dto;
	}
	

}
