package com.aegis.webapp.utils;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
 
public class WebUtils {
 
    public static String isAdmin(User user) {
        String admin;
 
        Collection<GrantedAuthority> authorities = user.getAuthorities();
        if (authorities != null && !authorities.isEmpty()) {
            for (GrantedAuthority a : authorities) {
                	admin = a.getAuthority();
                	if (admin.equals("ROLE_ADMIN")) {
                		return "ADMIN";
                	}
            }
        }
        return"USER";
        }
    
    public static String isEmployee(User user) {
        String admin;
 
        Collection<GrantedAuthority> authorities = user.getAuthorities();
        if (authorities != null && !authorities.isEmpty()) {
            for (GrantedAuthority a : authorities) {
                	admin = a.getAuthority();
                	if (admin.equals("ROLE_EMPLOYEE")) {
                		return "EMPLOYEE";
                	}
            }
        }
        return"USER";
        }
    
    
}


