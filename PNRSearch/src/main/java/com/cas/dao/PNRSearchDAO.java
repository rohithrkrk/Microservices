package com.cas.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cas.dto.PnrDTO;

@Repository
public class PNRSearchDAO   {
	
	@Autowired
	PNRRepository pnrRepo;

	public PnrDTO fetchNames(String pnr) {	
	  Optional<PnrDTO> dto=pnrRepo.findById(pnr);
	  return dto.get();
	}
	
	public PnrDTO savePNRInfo(String pnr,String name) {
		PnrDTO pnrDto=new PnrDTO();
		pnrDto.setName(name);
		pnrDto.setPnrloc(pnr);
		return pnrRepo.save(pnrDto);
	}
	

}
