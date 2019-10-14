package com.cg.moviesforyou.MovieBookSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	@Query("FROM Movie WHERE movieId = :movieId AND showStatus = 0")
	public Movie findByMovieId(Integer movieId);
	
	@Query("FROM Movie WHERE showStatus = 0")
	public List<Movie> findAll();
	
	
}
