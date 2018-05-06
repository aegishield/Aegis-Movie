package com.aegis.webapp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aegis.webapp.entities.EmpSchedule;

@Repository
public interface EmpScheduleRepository extends JpaRepository<EmpSchedule,Long>{
	EmpSchedule findByScheduleId(Long scheduleId);
	EmpSchedule findByMonth(Integer month);
	EmpSchedule findByYear(Integer year);
	List<EmpSchedule> findAllByMonthAndYear(Integer month,Integer year);
	List<EmpSchedule> findAllByMonth(Integer month);
	List<EmpSchedule> findAllByYear(Integer year);
}
