package com.cg.moviesforyou.MovieBookSpringBoot.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.NonNull;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "theatre")

public class Theatre {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "theatre_id")
	private Integer theatreId;
	
	@Column(name = "theatre_name")
	private String theatreName;
	
	
	@Column(name = "theatre_city")
	private String cityName;
	
	@Column(name = "city_pincode")
	private Integer cityPincode;
	
	
	@ManyToMany(mappedBy = "theatre", cascade = CascadeType.PERSIST)
	private List<Movie> movieList;	
	@OneToMany(mappedBy = "theatre")
	private List<Show> showsList;
	
	
	
	@CreatedBy
	protected String createdBy;
		@CreatedDate
		@Temporal(TemporalType.TIMESTAMP)
		protected Date creationDate;
		@LastModifiedBy
		protected String lastModifiedBy;
		@LastModifiedDate
		@Temporal(TemporalType.TIMESTAMP)
		protected Date lastModifiedDate;
		
	public Theatre(Integer theatreId, String theatreName, Integer cityPincode, String cityName, List<Movie> movieList,
			List<Show> showsList) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.cityPincode = cityPincode;
		this.cityName = cityName;
		this.movieList = movieList;
		this.showsList = showsList;
	}

	public Theatre() {
		// TODO Auto-generated constructor stub
	}

	public Integer getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public Integer getCityPincode() {
		return cityPincode;
	}

	public void setCityPincode(Integer cityPincode) {
		this.cityPincode = cityPincode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public List<Show> getShowsList() {
		return showsList;
	}

	public void setShowsList(List<Show> showsList) {
		this.showsList = showsList;
	}

}
