package com.cg.moviesforyou.dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.cg.moviesforyou.dto.Booking;
import com.cg.moviesforyou.dto.Customer;
import com.cg.moviesforyou.dto.Movie;
import com.cg.moviesforyou.dto.Show;
import com.cg.moviesforyou.dto.Theatre;
import com.cg.moviesforyou.exception.UserException;

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
}
