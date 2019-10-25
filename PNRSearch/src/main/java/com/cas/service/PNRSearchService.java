package com.cas.service;



import com.cas.dao.PNRSearchDAO;
import com.cas.dto.PnrDTO;

public class PNRSearchService {
	
	@Aut
	private PNRSearchDAO pnrDao;

	public PnrDTO fetchPNR(String name) {
		PnrDTO dto=pnrDao.fetchNames();
		return dto;
	}
	
}
