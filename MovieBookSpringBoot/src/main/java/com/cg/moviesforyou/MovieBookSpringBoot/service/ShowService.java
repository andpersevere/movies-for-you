package com.cg.moviesforyou.MovieBookSpringBoot.service;

import java.util.List;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.Show;

public interface ShowService {
	
	public Show addShow(Show show);
	public List<Show> findAll();
	public Show find(Integer showId);
	public List<Show> getShows(Integer movieid, Integer theatreID);
	public Integer getAvailableSeats(int showId);
	public Boolean updateSeats(int showId, Integer available_seats, Integer seatsBooked);
	
}
