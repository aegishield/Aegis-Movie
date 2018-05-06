package com.aegis.webapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)   
	@Column(name = "emp_id")
	private Long employeeId;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name ="nama")
	private String name;
	
	@Column(name ="alamat")
	private String address;
	
	@Column(name ="gaji")
	private Integer gaji;
	
	@Column(name = "bonus")
	private Integer bonus;

	
	public Employee() {
		super();
	}

	public Employee(Long employeeId, Long userId, String name, String address, Integer gaji, Integer bonus) {
		super();
		this.employeeId = employeeId;
		this.userId = userId;
		this.name = name;
		this.address = address;
		this.gaji = gaji;
		this.bonus = bonus;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getGaji() {
		return gaji;
	}

	public void setGaji(Integer gaji) {
		this.gaji = gaji;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}
	
	
}
