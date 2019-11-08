package com.cas.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cas.dao.PNRSearchDAO;
import com.cas.dto.PnrDTO;

@RestController
public class PNRService {
	
	@Autowired
	private PNRSearchDAO pnrDao;
	
    @RequestMapping("/fetch/{recloc}")
	public PnrDTO fetchPNR( @PathVariable("recloc") String recloc  ) {
		PnrDTO dto=pnrDao.fetchNames(recloc);
		return dto;
	}
    
    public PnrDTO savePnr(String name,String pnrloc) {
    	return pnrDao.savePNRInfo(name, pnrloc);
    	
    }
	
}
