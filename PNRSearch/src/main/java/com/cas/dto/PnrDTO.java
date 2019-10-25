package com.cas.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;




@Entity
@Table(name ="tbl_PNRInfo",schema = "pnr")
public class PnrDTO {

	@Column(name="PnrSearch")
	private String pnrloc;
	
    @Column(name="Name")
	private String Name;



	public String getPnrloc() {
		return pnrloc;
	}

	public void setPnrloc(String pnrloc) {
		this.pnrloc = pnrloc;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	
}
