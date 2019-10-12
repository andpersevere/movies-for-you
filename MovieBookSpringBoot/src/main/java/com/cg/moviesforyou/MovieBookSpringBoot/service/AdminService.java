package com.cg.moviesforyou.MovieBookSpringBoot.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.Admin;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Movie;
import com.cg.moviesforyou.MovieBookSpringBoot.exception.UserException;

public interface AdminService {
	public Admin save(Admin admin);
	public List<Admin> findAll();
	public Admin find(Integer adminId);
	public Admin validateAdminLogin(String userName, String userPass) throws UserException;
	
	
	
	
}
