package com.cg.moviesforyou.MovieBookSpringBoot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.Theatre;
import com.cg.moviesforyou.MovieBookSpringBoot.repository.TheatreRepository;

@Service("theatreService")
@Transactional
public class TheatreServiceImpl implements TheatreService {
	
	@Autowired
	TheatreRepository theatreRepository;

	public Theatre addTheatre(Theatre theatre) {
		return theatreRepository.save(theatre);
	}

	public List<Theatre> findAll() {
		return theatreRepository.findAll();
	}

	public Theatre findTheatre(Integer theatreId) {
		return theatreRepository.findById(theatreId).get();
	}



}