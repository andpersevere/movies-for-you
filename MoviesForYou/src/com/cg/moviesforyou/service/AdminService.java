package com.cg.moviesforyou.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.cg.moviesforyou.dto.Admin;
import com.cg.moviesforyou.dto.Movie;
import com.cg.moviesforyou.exception.UserException;

public interface AdminService {
	public Admin save(Admin admin);
	public List<Admin> findAll();
	public Admin find(Integer adminId);
	public Admin remove(Integer adminId);
	
	public boolean addShowToTheatre(Integer showId, Integer theatreId);
	public boolean addMovieToTheatre(Integer movieId, Integer showId, Integer theatreId);
	public Admin validateAdminLogin(String userName, String userPass) throws UserException;
	public List<Movie> getMovies();
	public List<String> getTheatreByMovieId(Integer movieId);
	public Date getReleaseDate(Integer movieId);
	public Boolean setShowStatus(Integer movieID);
}
