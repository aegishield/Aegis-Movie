package com.aegis.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aegis.webapp.entities.HourDetail;

public interface HourRepository extends JpaRepository<HourDetail, Long> {
	HourDetail findByHourId(Long hourId);
}
