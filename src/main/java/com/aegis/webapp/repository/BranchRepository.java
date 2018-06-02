package com.aegis.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aegis.webapp.entities.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
	Branch findByBranchId(Long branchId);
	Branch findByAddress(String address);
	List<Branch> findAllByStatus(boolean status);
	List<Branch> findAllByOrderByBranchId();
}
