package com.cg.moviesforyou.MovieBookSpringBoot.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="movie_show")
public class Show {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="show_id")
	private Integer showId;
	@Column(name="showDate")
	@Temporal(TemporalType.DATE)
    private Date showDate;
	@Column(name="showTime")
	@Temporal(TemporalType.TIME)
    private Date showTime;
	@Column(name="available_seats")
    private Integer availableSeats;
	@Column(name="blocked_seats")
    private Integer blockedSeats=20;
	
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
    private Movie movie;
	@ManyToOne
	@JoinColumn(name = "theatre_id")
    private Theatre theatre;
	@OneToMany(mappedBy = "show")
	private List<Booking> bookings;
	
	
	public Show() {
		
		// TODO Auto-generated constructor stub
	}


	public Show(Integer showId, Date showDate, Date showTime, Integer availableSeats, Integer blockedSeats,
			Movie movie, Theatre theatre, List<Booking> bookings) {
		super();
		this.showId = showId;
		this.showDate = showDate;
		this.showTime = showTime;
		this.availableSeats = availableSeats;
		this.blockedSeats = blockedSeats;
		this.movie = movie;
		this.theatre = theatre;
		this.bookings = bookings;
	}


	public Integer getShowId() {
		return showId;
	}


	public void setShowId(Integer showId) {
		this.showId = showId;
	}


	public Date getShowDate() {
		return showDate;
	}


	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}


	public Date getShowTime() {
		return showTime;
	}


	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}


	public Integer getAvailableSeats() {
		return availableSeats;
	}


	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}


	public Integer getBlockedSeats() {
		return blockedSeats;
	}


	public void setBlockedSeats(Integer blockedSeats) {
		this.blockedSeats = blockedSeats;
	}


	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	public Theatre getTheatre() {
		return theatre;
	}


	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}


	public List<Booking> getBookings() {
		return bookings;
	}


	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
   
}

    