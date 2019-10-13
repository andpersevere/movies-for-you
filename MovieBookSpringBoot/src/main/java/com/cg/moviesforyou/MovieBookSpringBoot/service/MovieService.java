package com.cg.moviesforyou.MovieBookSpringBoot.service;

import java.util.List;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.Movie;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Theatre;

public interface MovieService {
	public Movie addMovie(Movie novie);
	public List<Movie> findAll();
	public Movie findMovie(Integer movieId);
	public List<Theatre> getTheatreByMovieId(Integer movieID);
	public Boolean removeMovie(Integer movieID);
	
}
