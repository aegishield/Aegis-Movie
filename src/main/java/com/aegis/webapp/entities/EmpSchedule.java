package com.aegis.webapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jadwal_karyawan")
public class EmpSchedule {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)   
	@Column(name = "id_jadwal")
	private Long scheduleId;
	
	@Column(name = "bulan")
	private Integer month;
	
	@Column(name ="tahun")
	private Integer year;

	
	public EmpSchedule() {
		super();
	}

	public EmpSchedule(Long scheduleId, Integer month, Integer year) {
		super();
		this.scheduleId = scheduleId;
		this.month = month;
		this.year = year;
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	
}
