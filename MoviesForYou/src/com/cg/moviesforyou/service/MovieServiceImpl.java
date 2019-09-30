package com.cg.moviesforyou.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.moviesforyou.dao.MovieDao;
import com.cg.moviesforyou.dto.Movie;

@Service("movieService")
@Transactional
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieDao movieDao;

	public Movie save(Movie novie) {
		return movieDao.save(novie);
	}

	public List<Movie> findAll() {
		return movieDao.findAll();
	}

	public Movie find(Integer movieId) {
		return movieDao.find(movieId);
	}

	public Movie remove(Integer movieId) {
		return movieDao.remove(movieId);
	}

}
