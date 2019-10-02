package com.cg.moviesforyou.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.moviesforyou.dao.ShowDao;
import com.cg.moviesforyou.dto.Show;

@Service("showService")
@Transactional
public class ShowServiceImpl implements ShowService {
	
	@Autowired
	ShowDao showDao;

	public Show save(Show show) {
		return showDao.save(show);
	}

	public List<Show> findAll() {
		return showDao.findAll();
	}

	public Show find(Integer showId) {
		return showDao.find(showId);
	}

	public Show remove(Integer showId) {
		return showDao.remove(showId);
	}

}
