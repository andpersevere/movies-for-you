package com.cg.moviesforyou.service;

import java.util.List;

import com.cg.moviesforyou.dto.Show;

public interface ShowService {
	
	public Show save(Show show);
	public List<Show> findAll();
	public Show find(Integer showId);
	public Show remove(Integer showId);
}
