package com.cas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cas.dao.PNRRepository;
import com.cas.dto.PnrDTO;

@SpringBootApplication
public class PNRSearchStarter   implements ApplicationRunner{
	
	@Autowired
	PNRRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(PNRSearchStarter.class, args);
		
		
	}



	@Override
	public void run(ApplicationArguments args) throws Exception {
		/*
		 * PnrDTO pnr=new PnrDTO(); pnr.setName("Rohith"); pnr.setPnrloc("6JXMNY");
		 * repo.save(pnr); repo.findAll().forEach(System.out::println);
		 */
      
		
	}
}
