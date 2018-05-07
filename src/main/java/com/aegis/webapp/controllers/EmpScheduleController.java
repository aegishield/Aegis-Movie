package com.aegis.webapp.controllers;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aegis.webapp.entities.DailyEmpSchedule;
import com.aegis.webapp.entities.EmpSchedule;
import com.aegis.webapp.repository.AppUserRepository;
import com.aegis.webapp.repository.DailyEmpScheduleRepository;
import com.aegis.webapp.repository.EmpScheduleRepository;
 
@Controller
public class EmpScheduleController {
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private EmpScheduleRepository empScheduleRepository;
	
	@Autowired
	private DailyEmpScheduleRepository dailyEmpScheduleRepository;
	
	@RequestMapping(value = "/admin/empSchedule", method = RequestMethod.GET)
	public String schedulePage(Model model, @RequestParam(value = "month",required = false) Integer month,@RequestParam(value = "year",required = false) Integer year,EmpSchedule schedule) {
    	model.addAttribute("month",month);
    	model.addAttribute("year",year);
    	model.addAttribute("schedule",schedule);
        if(month == null && year == null) {
            return "empSchedule";
        } else if(month!= null && year != null) {
        	List<EmpSchedule> schedules = empScheduleRepository.findAllByMonthAndYear(month, year);
        	List<Long> ids = new ArrayList<Long>();
        	for (EmpSchedule empSchedule : schedules) {
				ids.add(empSchedule.getScheduleId());
			}
        	List<DailyEmpSchedule> dSchedules = dailyEmpScheduleRepository.findByScheduleIdIn(ids);
        	model.addAttribute("dSchedules",dSchedules);
        	model.addAttribute("schedules",schedules);
        } else if(month!= null) {
        	List<EmpSchedule> schedules = empScheduleRepository.findAllByMonth(month);
        	List<Long> ids = new ArrayList<Long>();
        	for (EmpSchedule empSchedule : schedules) {
				ids.add(empSchedule.getScheduleId());
			}
        	List<DailyEmpSchedule> dSchedules = dailyEmpScheduleRepository.findByScheduleIdIn(ids);
        	model.addAttribute("dSchedules",dSchedules);
        	model.addAttribute("schedules",schedules);
        } else if(year!= null) {
        	List<EmpSchedule> schedules = empScheduleRepository.findAllByYear(year);
        	List<Long> ids = new ArrayList<Long>();
        	for (EmpSchedule empSchedule : schedules) {
				ids.add(empSchedule.getScheduleId());
			}
        	List<DailyEmpSchedule> dSchedules = dailyEmpScheduleRepository.findByScheduleIdIn(ids);
        	model.addAttribute("dSchedules",dSchedules);
        	model.addAttribute("schedules",schedules);
        }
         
        return "empSchedule";
    }
	
	@RequestMapping(value = "/admin/empSchedule", method = RequestMethod.POST)
	public String postSchedulePage(Model model, @RequestParam(value = "month",required = false) Integer month,@RequestParam(value = "year",required = false) Integer year,EmpSchedule schedule){
		
		return "empSchedule";
	}

	
   
}