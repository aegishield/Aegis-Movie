package com.aegis.webapp.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aegis.webapp.entities.AppUser;
import com.aegis.webapp.entities.Booking;
import com.aegis.webapp.entities.Employee;
import com.aegis.webapp.repository.AppUserRepository;
import com.aegis.webapp.repository.BookingRepository;
import com.aegis.webapp.repository.EmployeeRepository;
import com.aegis.webapp.utils.WebUtils;

@Controller
public class EmployeeController {
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String employeePage(Model model, Principal principal) {
        
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        AppUser user = appUserRepository.findByUserName(loginedUser.getUsername());
        Employee emp = employeeRepository.findByUserId(user.getUserId());
        if(emp == null) {
        	return "redirect:/employee/setProfile";
        }
        String employee = WebUtils.isEmployee(loginedUser);
        model.addAttribute("employee", employee);
         
        return "employeePage";
    }
	
	@RequestMapping(value = "employee/addBalance", method = RequestMethod.GET)
	public String showAddBalancePage(Model model,@ModelAttribute("user") AppUser user) {
        
		model.addAttribute("user",user);
		
        return "addBalancePage";
    }
	
	@RequestMapping(value = "employee/addBalance", method = RequestMethod.POST)
	public String adminPage(Model model,@ModelAttribute("user") AppUser user,BindingResult bindingResult) {
        
		AppUser myUser = appUserRepository.findByUserName(user.getUserName());
		if (myUser == null) {
			model.addAttribute("userNotFound","User not found in database!");
			bindingResult.reject("userName");
		} else {
			model.addAttribute("messageSuccess","Balance successfully added!");
			myUser.setBalance(myUser.getBalance() + user.getBalance());
			appUserRepository.save(myUser);
		}
         
        return "addBalancePage";
    }
	
	@RequestMapping(value = "employee/setProfile", method = RequestMethod.GET)
	public String showSetUserProfilePage(Model model,Principal principal) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        AppUser user = appUserRepository.findByUserName(loginedUser.getUsername());
        Employee empExists = employeeRepository.findByUserId(user.getUserId());
        if(empExists == null) {
        	Employee emp = new Employee();
    		model.addAttribute("employee",emp);
        } else {
        	model.addAttribute("employee",empExists);
        }
        
        return "setEmpProfilePage";
    }
	
	@RequestMapping(value = "employee/setProfile", method = RequestMethod.POST)
	public String saveUserProfile(Model model,@ModelAttribute("employee") Employee emp,BindingResult bindingResult,HttpServletRequest request,Principal principal) {
		User loginedUser = (User) ((Authentication) principal).getPrincipal();
        AppUser user = appUserRepository.findByUserName(loginedUser.getUsername());
		model.addAttribute("messageSuccess","Your profile has been set!");
		if(emp.getUserId() == null) {
			emp.setGaji(0);
			emp.setBonus(0);
        	emp.setUserId(user.getUserId());
		}
		employeeRepository.save(emp);
        return "setEmpProfilePage";
    }
	
	@RequestMapping(value = "employee/confirm", method = RequestMethod.GET)
	public String showConfirmationPage(Model model,Booking booking,AppUser user) {
        
		model.addAttribute("user",user);
		model.addAttribute("booking",booking);
        return "confirmPage";
    }
	
	@RequestMapping(value = "employee/confirm", method = RequestMethod.POST)
	public String saveConfirmationPage(Model model,Booking booking,BindingResult bindingResultBooking,@ModelAttribute("user") AppUser user,BindingResult bindingResultUser) {
        AppUser userExists = appUserRepository.findByUserName(user.getUserName());
        if(userExists==null) {
        	bindingResultUser.reject("userNotExists");
        	model.addAttribute("error","User not found in database!");
        	return "confirmPage";
        } else {
        	Booking bookExists = bookingRepository.findByBookingIdAndUserId(booking.getBookingId(),userExists.getUserId());
        	if(bookExists == null) {
        		bindingResultBooking.reject("bookingNotExists");
            	model.addAttribute("error","Booking not found in database!");
            	return "confirmPage";
        	} else if(bookExists.isStatus() == true){
        		bindingResultBooking.reject("bookingConfirmed");
        		model.addAttribute("error","Booking already confirmed!");
            	return "confirmPage";
        	} else {
        		bookExists.setStatus(true);
        		bookingRepository.save(bookExists);
        		model.addAttribute("success","Booking successfully confirmed!");
        	}
        }
        return "confirmPage";
    }
	
}
