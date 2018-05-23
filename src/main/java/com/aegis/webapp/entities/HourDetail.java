package com.aegis.webapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detail_jam")
public class HourDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)   
	@Column(name = "id_jam")
	private Long hourId;
	
	@Column(name = "jam_mulai")
	private Integer startHour;
	
	@Column(name = "jam_selesai")
	private Integer endHour;

	public HourDetail(Long hourId, Integer startHour, Integer endHour) {
		super();
		this.hourId = hourId;
		this.startHour = startHour;
		this.endHour = endHour;
	}

	public HourDetail() {
		super();
	}

	public Long getHourId() {
		return hourId;
	}

	public void setHourId(Long hourId) {
		this.hourId = hourId;
	}

	public Integer getStartHour() {
		return startHour;
	}

	public void setStartHour(Integer startHour) {
		this.startHour = startHour;
	}

	public Integer getEndHour() {
		return endHour;
	}

	public void setEndHour(Integer endHour) {
		this.endHour = endHour;
	}
	
	
}
