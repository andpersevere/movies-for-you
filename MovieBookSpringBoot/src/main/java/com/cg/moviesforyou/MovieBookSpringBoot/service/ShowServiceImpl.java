package com.cg.moviesforyou.MovieBookSpringBoot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.Show;
import com.cg.moviesforyou.MovieBookSpringBoot.repository.ShowRepository;

@Service("showService")
@Transactional
public class ShowServiceImpl implements ShowService {

	@Autowired
	ShowRepository showRepository;

	public Show addShow(Show show) {
		return showRepository.save(show);
	}

	public List<Show> findAll() {
		return showRepository.findAll();
	}

	public Show find(Integer showId) {
		return showRepository.findById(showId).get();
	}

	@Override
	public List<Show> getShows(Integer movieid, Integer theatreID) {
		List<Show> showsList = findAll();
		List<Show> selectedShows = new ArrayList<Show>();
		for (int i = 0; i < showsList.size(); i++) {
			if (showsList.get(i).getMovie().getMovieId() == movieid
					&& showsList.get(i).getTheatre().getTheatreId() == theatreID) {
				System.out.println("show found");
				selectedShows.add(showsList.get(i));
				System.out.println("Show added");
			}
		}
		return selectedShows;
	}

	@Override
	public Integer getAvailableSeats(int showId) {
		// TODO Auto-generated method stub
		return showRepository.findById(showId).get().getAvailableSeats();
	}

	@Override
	@Transactional
	public Boolean updateSeats(int showId, Integer available_seats, Integer seatsBooked) {
		Show show=showRepository.findById(showId).get();
		show.setAvailableSeats(available_seats-seatsBooked);
		return true;
		
	}

}
