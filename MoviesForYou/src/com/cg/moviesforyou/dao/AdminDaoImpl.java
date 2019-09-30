package com.cg.moviesforyou.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.moviesforyou.dto.Admin;
import com.cg.moviesforyou.dto.Movie;
import com.cg.moviesforyou.dto.Show;
import com.cg.moviesforyou.dto.Theatre;
import com.cg.moviesforyou.exception.UserException;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {
	
	@PersistenceContext
	EntityManager manager;
	
	public static int flag = 0;

	public Admin save(Admin admin) {
		Query query = manager.createQuery("FROM Admin");
		List<Admin> adminList = query.getResultList();

		if (adminList.isEmpty()) {
			manager.persist(admin);
			System.out.println("Admin has been added successfully");
			return admin;
		}
		System.out.println("Admin already exists in database");
		return null;
	}

	public List<Admin> findAll() {
		Query query = manager.createQuery("FROM Admin");
		List<Admin> adminList = query.getResultList();

		if (adminList.isEmpty()) {
			System.out.println("No admins in the database.");
			return null;
		} else {
			return adminList;
		}
	}

	public Admin find(Integer adminId) {
		Admin admin = manager.find(Admin.class, adminId);
		if (admin == null) {
			System.out.println("Admin not found!!");
			return null;
		} else {
			return admin;
		}
	}

	@Transactional
	public Admin remove(Integer adminId) {
		Admin admin = manager.find(Admin.class, adminId);
		flag = 1;
		System.out.println("Admin has been removed");
		return admin;
	}

	@Transactional
	public boolean addShowToTheatre(Integer showId, Integer theatreId) {
		Theatre theatre = manager.find(Theatre.class, theatreId);
		Show show = manager.find(Show.class, showId);
		
		if (theatre == null || show == null) {
			System.out.println("Theatre not found!!");
			return false;
		} else {
			show.setTheatre(theatre);
			return true;
		}
	}

	public boolean addMovieToTheatre(Integer movieId, Integer showId, Integer theatreId) {
		Theatre theatre = manager.find(Theatre.class, theatreId);
		Show show = manager.find(Show.class, showId);
		Movie movie = manager.find(Movie.class, movieId);

		if (theatre == null || show == null) {
			System.out.println("Theatre/Show not found!!");
			return false;
		} else {
			show.setMovie(movie);
			theatre.getMovieList().add(movie);
			movie.getTheatre().add(theatre);
			return true;
		}
	}

	public Admin validateAdminLogin(String userName, String userPass) throws UserException {
		Query query = manager.createQuery("FROM Admin WHERE adminName = :first AND adminPassword = :second");
		query.setParameter("first", userName);
		query.setParameter("second", userPass);

		List<Admin> adminList = query.getResultList();

		if (adminList.isEmpty()) {
			throw new UserException("Admin Doesn't exist");
		}
		return adminList.get(0);
	}


	public List<Movie> getMovies() {
		Query query = manager.createQuery("From Movie where showStatus = :first");
		query.setParameter("first",0);
		List<Movie> movieList=query.getResultList();
		return movieList;
	}

	public List<String> getTheatreByMovieId(Integer movieId) {
		Movie movie = manager.find(Movie.class, movieId);
		if (movie != null) {
			List<Theatre> theatresList = movie.getTheatre();
			List<String> nameIdList = new ArrayList<String>();
			theatresList.forEach(theatre -> {
				nameIdList.add(theatre.getTheatreId() + " " + theatre.getTheatreName());
			});
			return nameIdList;
		}
		return null;
	}

	public Date getReleaseDate(Integer movieID) {
		Movie movie = manager.find(Movie.class, movieID);
		if (movie == null) {
			System.out.println("Movie not found!!");
			return null;
		} else {
			return movie.getMovieReleaseDate();
		}
	}


	public Boolean setShowStatus(Integer movieID) {
		Movie movie = manager.find(Movie.class,movieID);
		manager.getTransaction().begin();
		movie.setShowStatus(1);
		manager.getTransaction().commit();
		
		return true;	
	}

}