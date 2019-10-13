package com.cg.moviesforyou.MovieBookSpringBoot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.Movie;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Theatre;
import com.cg.moviesforyou.MovieBookSpringBoot.repository.MovieRepository;

@Service("movieService")
@Transactional
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieRepository movieRepository;

	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	public Movie findMovie(Integer movieId) {
		return movieRepository.findById(movieId).get();
	}

	@Override
	public List<Theatre> getTheatreByMovieId(Integer movieID) {
		// TODO Auto-generated method stub
		return movieRepository.findById(movieID).get().getTheatre();
	}

	@Override
	@Transactional
	public Boolean removeMovie(Integer movieid) {
		// TODO Auto-generated method stub
		Movie movies=movieRepository.findById(movieid).get();
		movies.setShowStatus(1);
		return true;
	}

}
