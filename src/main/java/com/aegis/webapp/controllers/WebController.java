package com.aegis.webapp.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aegis.webapp.entities.AppUser;
import com.aegis.webapp.entities.Movie;
import com.aegis.webapp.repository.AppUserRepository;
import com.aegis.webapp.repository.MovieRepository;
import com.aegis.webapp.utils.WebUtils;
 
@Controller
public class WebController {
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model,Principal principal) {
    	if (principal != null) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String admin = WebUtils.isAdmin(loginedUser);
        String employee = WebUtils.isEmployee(loginedUser);
        model.addAttribute("admin", admin);
        model.addAttribute("employee",employee);
    	}
    	List<Movie> movies = movieRepository.findTop4ByOrderByReleaseDateDesc();
    	model.addAttribute("movies",movies);
        return "welcomePage";
    }
 
 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model,Principal principal) {
    	if (principal != null) {
    		return "redirect:/";
    	}
        return "loginPage";
    }
    
    
 
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        return "logoutSuccessfulPage";
    }
 
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
  
    	
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        
        String admin = WebUtils.isAdmin(loginedUser);
        model.addAttribute("admin", admin);
        String employee = WebUtils.isEmployee(loginedUser);
        model.addAttribute("employee",employee);
        AppUser myUser = appUserRepository.findByUserName(loginedUser.getUsername());
        System.out.println(myUser.getDateCreated());
        model.addAttribute("user",myUser);
        return "userInfoPage";
    }
 
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
            String admin = WebUtils.isAdmin(loginedUser);
            model.addAttribute("admin", admin);
 
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
 
        }
 
        return "403Page";
    }
    

}