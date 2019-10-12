package com.cg.moviesforyou.MovieBookSpringBoot.service;

import java.time.LocalDate;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.Admin;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Movie;
import com.cg.moviesforyou.MovieBookSpringBoot.exception.UserException;
import com.cg.moviesforyou.MovieBookSpringBoot.repository.AdminRepository;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminRepository adminRepository;
	

	public Admin save(Admin admin) {
		return adminRepository.save(admin);
	}

	public List<Admin> findAll() {
		return adminRepository.findAll();
	}

	public Admin find(Integer adminId) {
		return adminRepository.findById(adminId).get();
	}


	public Admin validateAdminLogin(String userName, String userPass) throws UserException {
		return adminRepository.findByAdminNameAndAdminPassword(userName, userPass);
	}

}
