package com.aegis.webapp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aegis.webapp.entities.DailyEmpSchedule;

@Repository
public interface DailyEmpScheduleRepository extends JpaRepository<DailyEmpSchedule,Long>{
	DailyEmpSchedule findByDailyScheduleId(Long dailyScheduleId);
	List<DailyEmpSchedule> findAllByScheduleId(Long scheduleId);
	List<DailyEmpSchedule> findAllByDay(Integer day);
	List<DailyEmpSchedule> findByScheduleIdIn(List<Long> scheduleId);
}