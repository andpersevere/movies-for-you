package com.cg.moviesforyou.MovieBookSpringBoot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.Show;

@Repository("showDao")
public class ShowDaoImpl implements ShowDao {

	@PersistenceContext
	EntityManager manager;
	public static int flag = 0;

	@Transactional
	public Show save(Show show) {
		manager.persist(show);
		return show;
	}

	public List<Show> findAll() {
		Query query = manager.createQuery("FROM Show");
		List<Show> showList = query.getResultList();
		if (showList.isEmpty()) {
			System.out.println("No Shows in the database.");
			return null;
		} else {
			return showList;
		}
	}

	public Show find(Integer showId) {
		Show show = manager.find(Show.class, showId);
		if (show == null) {
			System.out.println("Show not found!!");
			return null;
		} else {
			return show;
		}
	}

	@Transactional
	public Show remove(Integer showId) {
		Show show = manager.find(Show.class, showId);
		flag = 1;
		System.out.println("Show has been removed");
		return show;
	}

	@Transactional
	public Show addMovieToShow(Integer movieId) {
		return null;
	}
}
