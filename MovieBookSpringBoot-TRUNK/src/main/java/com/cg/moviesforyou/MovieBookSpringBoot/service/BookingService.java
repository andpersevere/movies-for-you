package com.cg.moviesforyou.MovieBookSpringBoot.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.Booking;

public interface BookingService {

	public Booking addBooking(Booking booking);
	public BigInteger getBookingId(BigInteger customerId);
	public List<Booking> viewBookings(BigInteger userID);
	public Boolean cancelBooking(BigInteger bookingId);

}
