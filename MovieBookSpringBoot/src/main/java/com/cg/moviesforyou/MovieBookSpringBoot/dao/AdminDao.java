package com.cg.moviesforyou.MovieBookSpringBoot.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.Admin;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Movie;
import com.cg.moviesforyou.MovieBookSpringBoot.exception.UserException;

public interface AdminDao {
	
	public boolean addShowToTheatre(Integer showId, Integer theatreId);
	public Admin validateAdminLogin(String userName, String userPass) throws UserException;
	public Admin save(Admin admin);
	public Admin find(Integer adminId);
	public List<Admin> findAll();
	public boolean addMovieToTheatre(Integer movieId, Integer showId, Integer theatreId);
	public Admin remove(Integer adminId);
	public List<Movie> getMovies();
	public List<String> getTheatreByMovieId(Integer movieId);
	public Date getReleaseDate(Integer movieID);
	public Boolean setShowStatus(Integer movieID); 
}
