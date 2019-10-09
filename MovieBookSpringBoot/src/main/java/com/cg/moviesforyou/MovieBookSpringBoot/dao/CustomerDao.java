package com.cg.moviesforyou.MovieBookSpringBoot.dao;

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

public interface CustomerDao {

	public Customer addCustomer(Customer customer);
	public Customer validateCustomerLogin(String userName, String userPass) throws UserException;
	public List<Movie> getMovies();
	public List<Theatre> getTheatreByMovieId(Integer movieId);
	public List<Show> getShows(Integer theatreSelected, Integer theatreSelected2);
	public BigInteger getUserId(String userName);
	public Boolean addBooking(Booking booking) throws Exception;
	public List<Booking> viewBookings(BigInteger userID);
	public Boolean cancelBooking(BigInteger bookingid);
	public BigInteger getBookingId(BigInteger userId);
	public Date getReleaseDate(Integer movieId);
	public Integer getAvailableSeats(Integer showSelected);
	public Boolean updateSeats(Integer showSelected, Integer availableSeats, Integer bookedSeats);
	public List<Customer> findAll();
	
}
