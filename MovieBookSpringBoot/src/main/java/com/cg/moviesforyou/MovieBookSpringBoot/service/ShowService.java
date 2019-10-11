package com.cg.moviesforyou.MovieBookSpringBoot.service;

import java.util.List;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.Show;

public interface ShowService {
	
	public Show save(Show show);
	public List<Show> findAll();
	public Show find(Integer showId);
	public Show remove(Integer showId);
}
