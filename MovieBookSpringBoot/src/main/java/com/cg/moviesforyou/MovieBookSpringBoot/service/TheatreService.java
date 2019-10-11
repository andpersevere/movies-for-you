package com.cg.moviesforyou.MovieBookSpringBoot.service;

import java.util.List;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.Theatre;

public interface TheatreService {

	public Theatre save(Theatre theatre);
	public List<Theatre> findAll();
	public Theatre find(Integer theatreId);
	public Theatre remove(Integer theatreId);
		
}


