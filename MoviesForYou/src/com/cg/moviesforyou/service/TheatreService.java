package com.cg.moviesforyou.service;

import java.util.List;

import com.cg.moviesforyou.dto.Theatre;

public interface TheatreService {

	public Theatre save(Theatre theatre);
	public List<Theatre> findAll();
	public Theatre find(Integer theatreId);
	public Theatre remove(Integer theatreId);
		
}


