package com.cg.moviesforyou.MovieBookSpringBoot.repository;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.Admin;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Movie;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
//	@Query("FROM Admin WHERE adminName = :username AND adminPassword = :password")
	public Admin findByAdminNameAndAdminPassword(String username,String password);
	
	
}
