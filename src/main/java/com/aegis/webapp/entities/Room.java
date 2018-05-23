package com.aegis.webapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kamar")
public class Room {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)   
	@Column(name = "id_kamar")
	private Long roomId;
	
	@Column(name = "id_cabang")
	private Long branchId;
	
	@Column(name = "kapasitas")
	private Integer capacity;
	
	@Column(name = "jenis_kamar")
	private String type;

	@Column(name = "status")
	private boolean status;
	
	@Column(name = "harga")
	private Integer price;
	
	public Room() {
		super();
	}

	public Room(Long roomId, Long branchId, Integer capacity, String type,boolean status,Integer price) {
		super();
		this.roomId = roomId;
		this.branchId = branchId;
		this.capacity = capacity;
		this.type = type;
		this.status = status;
		this.price = price;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}
