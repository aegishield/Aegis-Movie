package com.aegis.webapp.controllers;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aegis.webapp.utils.WebUtils;

@Controller
public class EmployeeController {
	
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String adminPage(Model model, Principal principal) {
        
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        String admin = WebUtils.isAdmin(loginedUser);
        model.addAttribute("admin", admin);
         
        return "adminPage";
    }
}
