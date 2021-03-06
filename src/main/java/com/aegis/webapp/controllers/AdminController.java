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

import com.aegis.webapp.entities.AppUser;
import com.aegis.webapp.entities.Role;
import com.aegis.webapp.repository.AppUserRepository;
import com.aegis.webapp.repository.RoleRepository;
import com.aegis.webapp.utils.WebUtils;

@Controller
public class AdminController {
	    
		private AppUserRepository appUserRepository;
		private RoleRepository roleRepository;
		
		
		@Autowired
		public AdminController(AppUserRepository appUserRepository,
				RoleRepository roleRepository) {
			super();
			this.appUserRepository = appUserRepository;
			this.roleRepository = roleRepository;
		}

		@RequestMapping(value = "/admin", method = RequestMethod.GET)
		public String adminPage(Model model, Principal principal) {
	         
	        User loginedUser = (User) ((Authentication) principal).getPrincipal();
	        String employee = WebUtils.isEmployee(loginedUser);
	        String admin = WebUtils.isAdmin(loginedUser);
	        if(admin.equals("USER")) {
	        	return "redirect:/";
	        }
	        model.addAttribute("admin", admin);
	        model.addAttribute("employee",employee);

	         
	        return "adminPage";
	    }
		
		
		
		@RequestMapping(value="/admin/register", method = RequestMethod.GET)
		public String showRegistrationPage(Model model, AppUser user,Role role){
			model.addAttribute("user", user);
			model.addAttribute("role", role);
			return "adminRegister";
		}
		
		
		@RequestMapping(value="/admin/register", method = RequestMethod.POST)
		public String submitRegistration(Model model,@ModelAttribute("user") AppUser user,BindingResult bindingResult,@ModelAttribute("role") Role role, HttpServletRequest request){
			
			AppUser userNameExists = appUserRepository.findByUserName(user.getUserName());
			
			if(userNameExists == null) {
				model.addAttribute("userNotFound", "Oops!  Username not found in database!.");
				bindingResult.reject("userName");
			} else {
			
				role.setUserId(userNameExists.getUserId());
				
				List<Role> roleExists = roleRepository.findAllByUserId(userNameExists.getUserId());
				for (Role role2 : roleExists) {
					Long roleUser = role2.getRoleId();
					Long userId = role2.getUserId();
					if(roleUser == role.getRoleId() && userId == role.getUserId() ) {
						model.addAttribute("roleExists","Oops!  Username already assigned with that role!.");
						bindingResult.reject("role");
					}
				}
			}
			if (bindingResult.hasErrors()) { 
				return "adminRegister";	
			} else {
				model.addAttribute("messageSuccess", "Registration successfull!");
				roleRepository.save(role);
			}
			return "adminRegister";
		}
		
		
}
