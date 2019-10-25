package com.cas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cas.dto.PnrDTO;

public interface PNRRepository extends JpaRepository<PnrDTO	, String>{

}
