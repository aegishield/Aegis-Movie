package com.aegis.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aegis.webapp.entities.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
	 @Query(value = "SELECT role_Id FROM app_role WHERE role_name = :roleName", nativeQuery = true)
	 Long findIdByRole(@Param("roleName") String roleName);
	 List<Role> findAllByUserId(Long userId);
}
