package com.aegis.webapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cabang")
public class Branch {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)   
	@Column(name = "id_cabang")
	private Long branchId;
	
	@Column(name = "alamat")
	private String address;
	
	@Column(name = "status")
	private boolean status;
	
	public Branch() {
		super();
	}

	public Branch(Long branchId, String address,boolean status) {
		super();
		this.branchId = branchId;
		this.address = address;
		this.status = status;
	}
	
	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public boolean isStatus() {
		return status;
	}
	
	

	public void setStatus(boolean status) {
		this.status = status;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
