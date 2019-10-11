package com.cg.moviesforyou.MovieBookSpringBoot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.moviesforyou.MovieBookSpringBoot.dao.TheatreDao;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Theatre;

@Service("theatreService")
@Transactional
public class TheatreServiceImpl implements TheatreService {
	
	@Autowired
	TheatreDao theatreDao;

	public Theatre save(Theatre theatre) {
		return theatreDao.save(theatre);
	}

	public List<Theatre> findAll() {
		return theatreDao.findAll();
	}

	public Theatre find(Integer theatreId) {
		return theatreDao.find(theatreId);
	}

	public Theatre remove(Integer theatreId) {
		return theatreDao.remove(theatreId);
	}

}