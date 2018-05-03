package com.aegis.webapp.controllers;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aegis.webapp.entities.AppUser;
import com.aegis.webapp.entities.Role;
import com.aegis.webapp.repository.AppUserRepository;
import com.aegis.webapp.repository.RoleRepository;
import com.aegis.webapp.services.EmailService;

@Controller
public class RegisterController {
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private AppUserRepository appUserRepository;
	private RoleRepository roleRepository;
	private EmailService emailService;
	
	
	@Autowired
	public RegisterController(BCryptPasswordEncoder bCryptPasswordEncoder, AppUserRepository appUserRepository,
			EmailService emailService,RoleRepository roleRepository) {
		super();
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.appUserRepository = appUserRepository;
		this.emailService = emailService;
		this.roleRepository = roleRepository;
	}



	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView showRegistrationPage(ModelAndView modelAndView, AppUser user){
		modelAndView.addObject("user", user);
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processRegistrationForm(ModelAndView modelAndView,@Valid @ModelAttribute("user") AppUser user, BindingResult bindingResult, HttpServletRequest request) {
				
		
		
		AppUser userNameExists = appUserRepository.findByUserName(user.getUserName());
		if (userNameExists != null) {
			modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the username provided.");
			modelAndView.setViewName("register");
			AppUser userExists = appUserRepository.findByEmail(user.getEmail());
			
			if(userExists != null) {
				modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
				modelAndView.setViewName("register");
				bindingResult.reject("email");
			}
			bindingResult.reject("userName");
		}
				
		if (bindingResult.hasErrors()) { 
			modelAndView.setViewName("register");			
		} else { 
		
	    user.setEnabled(false);
	    user.setBalance(0);
	    user.setConfirmationToken(UUID.randomUUID().toString());
	    user.setEncrytedPassword(bCryptPasswordEncoder.encode(user.getEncrytedPassword()));
	        
	    appUserRepository.save(user);
			
		String appUrl = request.getScheme() + "://" + request.getServerName();
		
		SimpleMailMessage registrationEmail = new SimpleMailMessage();
		registrationEmail.setTo(user.getEmail());
		registrationEmail.setSubject("Registration Confirmation");
		registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
				+ appUrl + "/confirm?token=" + user.getConfirmationToken());
		registrationEmail.setFrom("noreply@domain.com");
		
		emailService.sendEmail(registrationEmail);
		
		modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + user.getEmail());
		modelAndView.setViewName("register");
			
	}
		return modelAndView;
	}
	
	@RequestMapping(value="/confirm", method = RequestMethod.GET)
	public ModelAndView confirmRegistration(ModelAndView modelAndView, @RequestParam("token") String token) {
			
		AppUser user = appUserRepository.findByConfirmationToken(token);
			
		if (user == null) { 
			modelAndView.addObject("messageFailed", "Oops!  This is an invalid confirmation link.");
		} else { 
			modelAndView.addObject("messageSuccess", "Registration successfull!");
			Role role = new Role();
			role.setUserId(user.getUserId());
			role.setRoleId(roleRepository.findIdByRole("ROLE_USER"));
			roleRepository.save(role);
			user.setEnabled(true);
			appUserRepository.save(user);
		}
		modelAndView.setViewName("confirm");
		return modelAndView;		
	}
}
