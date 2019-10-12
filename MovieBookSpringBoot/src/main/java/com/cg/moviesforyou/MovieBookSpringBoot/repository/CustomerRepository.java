package com.cg.moviesforyou.MovieBookSpringBoot.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.Booking;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Customer;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Movie;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Show;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Theatre;
import com.cg.moviesforyou.MovieBookSpringBoot.exception.UserException;

public interface CustomerRepository extends JpaRepository<Customer, BigInteger>{
	
//	@Query("FROM Customer WHERE customerName = :username AND customerPassword = :password")
	public Customer findByCustomerNameAndCustomerPassword(String username,String password);

//	@Query("FROM Customer WHERE customerName = :username")
	public Customer findByCustomerName(String userName);


}
