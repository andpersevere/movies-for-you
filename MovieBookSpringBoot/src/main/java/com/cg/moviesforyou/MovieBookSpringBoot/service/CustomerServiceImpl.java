package com.cg.moviesforyou.MovieBookSpringBoot.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.Booking;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Customer;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Movie;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Show;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Theatre;
import com.cg.moviesforyou.MovieBookSpringBoot.exception.UserException;
import com.cg.moviesforyou.MovieBookSpringBoot.repository.*;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer addCustomer(Customer customer) throws UserException {
		if (Validate.validate_customer(customer)) {
			return customerRepository.save(customer);
		}
		return null;
	}

	public Customer validateCustomerLogin(String userName, String userPass) throws UserException {
		return customerRepository.findByCustomerNameAndCustomerPassword(userName, userPass);
	}


	public BigInteger getUserId(String userName) {
		return customerRepository.findByCustomerName(userName).getCustomerId();
	}


	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

}
