package com.aegis.webapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jadwal_harian_karyawan")
public class DailyEmpSchedule {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)   
	@Column(name = "id_harian")
	private Long dailyScheduleId;
	
	@Column(name = "id_jadwal")
	private Long scheduleId;
	
	@Column(name ="tanggal")
	private Integer day;

	
	
	public DailyEmpSchedule(Long dailyScheduleId, Long scheduleId, Integer day) {
		super();
		this.dailyScheduleId = dailyScheduleId;
		this.scheduleId = scheduleId;
		this.day = day;
	}

	
	public DailyEmpSchedule() {
		super();
	}


	public Long getDailyScheduleId() {
		return dailyScheduleId;
	}

	public void setDailyScheduleId(Long dailyScheduleId) {
		this.dailyScheduleId = dailyScheduleId;
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	
	
	
	
}
