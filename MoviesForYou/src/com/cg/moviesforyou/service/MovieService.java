package com.cg.moviesforyou.service;

import java.util.List;

import com.cg.moviesforyou.dto.Movie;

public interface MovieService {
	public Movie save(Movie novie);
	public List<Movie> findAll();
	public Movie find(Integer movieId);
	public Movie remove(Integer movieId);
}
