package com.cg.moviesforyou.MovieBookSpringBoot.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.Booking;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Customer;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Movie;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Show;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Theatre;
import com.cg.moviesforyou.MovieBookSpringBoot.exception.UserException;

public interface CustomerService {

	public Customer addCustomer(Customer customer) throws UserException;
	public Customer validateCustomerLogin(String userName, String userPass) throws UserException;
	public BigInteger getUserId(String userName);	
	public List<Customer> findAll();

}
