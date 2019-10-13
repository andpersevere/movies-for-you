package com.cg.moviesforyou.MovieBookSpringBoot.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.Booking;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Show;
import com.cg.moviesforyou.MovieBookSpringBoot.repository.BookingRepository;

@Service("bookingService")
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Override
	public Booking addBooking(Booking booking) {
		// TODO Auto-generated method stub
		return bookingRepository.save(booking);

	}

	@Override
	public BigInteger getBookingId(BigInteger customerId) {
		// TODO Auto-generated method stub
		List<Booking> bookingsList = bookingRepository.findAll();
		for (int i = bookingsList.size() - 1; i >= 0; i++) {
			if (bookingsList.get(i).getCustomer().getCustomerId() == customerId) {
				return bookingsList.get(i).getBookingId();
			}
		}
		return null;
	}

	public List<Booking> viewBookings(BigInteger userID) {
		List<Booking> bookingsList = bookingRepository.findAll();
		List<Booking> bookings = new ArrayList<Booking>();
		for (int i = 0; i < bookingsList.size(); i++) {
			if (bookingsList.get(i).getCustomer().getCustomerId() == userID) {
				bookings.add(bookingsList.get(i));
			}
		}
		return bookings;
	}

	@Override
	@Transactional
	public Boolean cancelBooking(BigInteger bookingId) {
		// TODO Auto-generated method stub
		Booking booking=bookingRepository.findById(bookingId).get();
		booking.setFlag(1);
		return true;
	}
}
