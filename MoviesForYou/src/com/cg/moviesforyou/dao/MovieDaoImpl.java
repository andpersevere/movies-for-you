package com.cg.moviesforyou.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.moviesforyou.dto.Customer;
import com.cg.moviesforyou.dto.Movie;
import com.cg.moviesforyou.dto.Theatre;

@Repository("movieDao")
public class MovieDaoImpl implements MovieDao {
	@PersistenceContext
	EntityManager manager;
	private static int flag = 1;

	@Transactional
	public Movie save(Movie movie) {
			manager.persist(movie);
			return movie;
		}

	public List<Movie> findAll() {
		Query query = manager.createQuery("FROM Movie where showStatus = :first");
		query.setParameter("first", 0);
		List<Movie> movieList = query.getResultList();
		if (movieList.isEmpty()) {
			System.out.println("No movies in the database.");
			return movieList;
		} else {
			return movieList;
		}
	}

	public Movie find(Integer movieId) {
		Movie movie = manager.find(Movie.class, movieId);
		if (movie == null) {
			System.out.println("Movie not found!!");
			return null;
		} else {
			return movie;
		}
	}

	@Transactional
	public Movie remove(Integer movieId) {
		Movie movie = manager.find(Movie.class, movieId);
		flag = 1;
		System.out.println("Movie has been removed");
		return movie;

	}

}
