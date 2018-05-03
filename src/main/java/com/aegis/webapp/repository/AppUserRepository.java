package com.aegis.webapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aegis.webapp.entities.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long>{
	AppUser findByUserName(String userName);
	AppUser findByEmail(String email);
	AppUser findByConfirmationToken(String token);
}
