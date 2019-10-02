package com.cg.moviesforyou.controller;
import com.cg.moviesforyou.dto.*;
import com.cg.moviesforyou.exception.UserException;
import com.cg.moviesforyou.service.*;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@Autowired
	TheatreService theatreService;
	@Autowired
	AdminService adminService;
	@Autowired
	ShowService showService;
	@Autowired
	MovieService movieService;
	@Autowired
	CustomerService customerService;
	@Autowired
	HttpSession session;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage() {
		return "HomePage";
	}

	@RequestMapping(value = "/logInPage", method = RequestMethod.GET)
	public String logInPage() {
		return "LogInPage";
	}

	@RequestMapping(value = "/validateLogInFromDatabase", method = RequestMethod.POST)
	public ModelAndView validateLogin(@RequestParam("username") String username,
			@RequestParam("password") String password, Map<String, Object> model) throws UserException {
		Customer customer = customerService.validateCustomerLogin(username, password);
		Admin admin = adminService.validateAdminLogin(username, password);
		if (customer != null) {
			model.put("customerData", customer);
			session.setAttribute("username", username);
			BigInteger userId = customerService.getUserId(username);
			System.out.println("id: " + userId);
			session.setAttribute("customerId", userId);
			return new ModelAndView("CustomerPage", "customerName", username);
		} else if (admin != null) {
			model.put("adminData", admin);
			session.setAttribute("username", username);
			return new ModelAndView("AdminPage", "adminName", username);
		} else {
			model.put("error", "invalid credentials");
			return new ModelAndView("LogInPage");
		}
	}

	@RequestMapping(value = "/addTheatrePage", method = RequestMethod.GET)
	public String addTheatrePage(@ModelAttribute("myTheatreForm") Theatre theatre, Map<String, Object> model) {
		List<String> myCityList = new ArrayList<String>();
		myCityList.add("Mumbai");
		myCityList.add("Bangalore");
		myCityList.add("Pune");
		myCityList.add("Hyderabad");
		myCityList.add("Chennai");
		myCityList.add("Kolkata");
		myCityList.add("Chandigarh");

		model.put("cityDataItem", myCityList);
		return "AddTheatrePage";
	}

	@RequestMapping(value = "/addMoviePage", method = RequestMethod.GET)
	public String addMoviePage(@ModelAttribute("myMovieForm") Movie movie, Map<String, Object> model,
			HttpServletRequest request) {
		List<String> myLanguageList = new ArrayList<String>();
		List<String> myGenreList = new ArrayList<String>();
		List<Theatre> theatresList = theatreService.findAll();
		List<String> theatres = new ArrayList<String>();
		for (Theatre theatre : theatresList) {
			theatres.add(theatre.getTheatreName());
		}
		myGenreList.add("Sci-Fi");
		myGenreList.add("Drama");
		myGenreList.add("Thriller");
		myGenreList.add("Crime");
		myGenreList.add("Comedy");
		myGenreList.add("Romance");

		myLanguageList.add("Hindi");
		myLanguageList.add("English");
		myLanguageList.add("Marathi");
		myLanguageList.add("Bengali");
		myLanguageList.add("Punjabi");
		request.setAttribute("theatresitem", theatresList);
		model.put("languageDataItem", myLanguageList);
		model.put("genreDataItem", myGenreList);
		return "AddMoviePage";
	}

	@RequestMapping(value = "/addShowPage", method = RequestMethod.GET)
	public String addShowPage(@ModelAttribute("myShowForm") Show show, Map<String, Object> model) {

		List<Movie> myMovieList = movieService.findAll();
		List<Theatre> myTheatreList = theatreService.findAll();
		Map<String, Movie> movieMap = new HashMap<>();
		Map<String, Theatre> theatreMap = new HashMap<>();
		Iterator<Movie> iteratorMovie = myMovieList.iterator();
		Movie movie;
		while (iteratorMovie.hasNext()) {
			movie = iteratorMovie.next();
			movieMap.put(movie.getMovieName(), movie);
		}
		Iterator<Theatre> iteratorTheatre = myTheatreList.iterator();
		Theatre theatre;
		while (iteratorTheatre.hasNext()) {
			theatre = iteratorTheatre.next();
			theatreMap.put(theatre.getTheatreName(), theatre);
		}
		model.put("movieDataItem", movieMap);
		model.put("theatreDataItem", theatreMap);
		return "AddShowPage";
	}

	// remove movie

	@RequestMapping(value = "/addTheatreToDatabase", method = RequestMethod.POST)
	public ModelAndView addTheatre(@ModelAttribute("myTheatreForm") Theatre theatre, BindingResult result) {
		theatreService.save(theatre);
		List<Theatre> myTheatreList = theatreService.findAll();
		return new ModelAndView("ShowTheatrePage", "theatreData", myTheatreList);
	}

	@RequestMapping(value = "/addMovieToDatabase", method = RequestMethod.POST)
	public ModelAndView addMovie(@ModelAttribute("myMovieForm") Movie movie, BindingResult result) {
		System.out.println("movie: " + movie);
		movieService.save(movie);
		List<Movie> myMovieList = movieService.findAll();
		return new ModelAndView("ShowMoviePage", "movieData", myMovieList);
	}

	@RequestMapping(value = "/addShowToDatabase", method = RequestMethod.POST)
	public ModelAndView addShow(@ModelAttribute("myShowForm") Show show, BindingResult result) {
		showService.save(show);
		List<Show> myShowList = showService.findAll();
		return new ModelAndView("ShowShowPage", "showData", myShowList);
	}

	@RequestMapping(value = "/signUpPage", method = RequestMethod.GET)
	public String signUpPage(@ModelAttribute("myCustomerForm") Customer customer, Map<String, Object> model) {
		return "SignUpPage";
	}

	@RequestMapping(value = "/addCustomerToDatabase", method = RequestMethod.POST)
	public ModelAndView addCustomer(@ModelAttribute("myCustomerForm") Customer customer, BindingResult result)
			throws UserException {
		if (result.hasErrors()) {
			System.out.println("Error in binding result. ");
		} else {
			Customer customerRegistered = customerService.addCustomer(customer);
			if (customerRegistered == null) {
				return new ModelAndView("InvalidRegisterationPage");
			} else {
				return new ModelAndView("LogInPage");
			}
		}
		return new ModelAndView("HomePage");
	}

	@RequestMapping(value = "/BookingPage", method = RequestMethod.GET)
	public String addBookingPage(Map<String, Object> model) {
		model.put("movieList", customerService.getMovies());
		return "ChoseMoviePage";
	}

	@RequestMapping(value = "/ChooseMovieSubmit", method = RequestMethod.POST)
	public String chooseTheatreRequest(@RequestParam("movieId") String movieId, Map<String, Object> model) {

		Integer movieID = Integer.parseInt(movieId);
		System.out.println("movie id " + movieID);
		List<Theatre> theatreList;

//			movieId = customerService.validateMovieId(movieID);
		theatreList = customerService.getTheatreByMovieId(movieID);
		if (theatreList.size() > 0) {
			System.out.println("in loop");
			model.put("theatresList", theatreList);
			System.out.println("model value done");
			session.setAttribute("movieId", movieID);
			System.out.println("session value set");

		} else {
			model.put("theatresList", theatreList);
			model.put("message", "Sorry, no theatre is currently showcasing this movie.");
			return "ChoseMoviePage";
		}

		return "ChoseTheatrePage";
	}

	@RequestMapping(value = "/choseTheatreSubmit", method = RequestMethod.POST)
	public String chooseShowRequest(@RequestParam("theatreId") String theatreId, Map<String, Object> model) {
		Integer theatreID = Integer.parseInt(theatreId);
		System.out.println("theatre is" + theatreID);
		Integer movieid = Integer.parseInt(session.getAttribute("movieId").toString());
		System.out.println("movie is" + movieid);
		List<Show> showsinList;
		showsinList = customerService.getShows(movieid, theatreID);

		System.out.println(showsinList);
		if (showsinList.size() > 0) {
			System.out.println("in loop");
			model.put("showsList", showsinList);
			System.out.println("model put done");
			session.setAttribute("theatreId", theatreID);
			System.out.println("theatre set as" + theatreID);

		} else {
			System.out.println("outside show loop");
			model.put("showsList", showsinList);
			model.put("message", "Sorry, no shows in this theatre .");
			return "ChoseTheatrePage";
		}

		return "ChoseShowPage";
	}

	@RequestMapping(value = "/choseShowSubmit", method = RequestMethod.POST)
	public ModelAndView addBookingToDatabase(@RequestParam("showId") String showId,
			@RequestParam("seatsBooked") Integer seatsBooked, Map<String, Object> model) throws Exception {

		Booking booking = new Booking();
		LocalDateTime dateTime;
		booking.setFlag(0);
		Integer available_seats = customerService.getAvailableSeats(Integer.parseInt(showId));
		if (seatsBooked > available_seats) {

			return new ModelAndView("ChoseShowPage", "error", "too many booked seats");
		} else {
			booking.setSeatsBooked(seatsBooked);
			Show show = new Show();
			show.setShowId(Integer.parseInt(showId));
			booking.setShow(show);
			Customer customer = new Customer();
			
			customer.setCustomerId((BigInteger)(session.getAttribute("customerId")));
			booking.setCustomer(customer);
			booking.setTotalCost(200 * seatsBooked);
			booking.setPayment("Done");
			Boolean bookingStatus = customerService.addBooking(booking);
			if (bookingStatus == true) {
				BigInteger bookingId=customerService.getBookingId((BigInteger)(session.getAttribute("customerId")));
				String bookingstatus = "Succesfull! ";
				model.put("bookingId", bookingId);
				session.setAttribute("bookingId", bookingId);
				customerService.updateSeats(Integer.parseInt(showId),available_seats, seatsBooked);
				return new ModelAndView("ViewBookingPage", "bookingstatus", bookingstatus);
			} else {
				String bookingstatus = "Unsuccessfull!";
				return new ModelAndView("ViewBookingPage", "bookingstatus", bookingstatus);
			}
		}
	}
	@RequestMapping(value = "/ViewBookingPage", method = RequestMethod.GET)
	public ModelAndView getAllBookings() {
		List<Booking> bookings=customerService.viewBookings((BigInteger)(session.getAttribute("customerId")));
		return new ModelAndView("ViewBookingPage", "data", bookings);
	}
	@RequestMapping(value = "/CancelBooking", method = RequestMethod.GET)
	public ModelAndView CancelBooking() {
	return new ModelAndView("CancelBooking","data","bookings");
	}
	@RequestMapping(value = "/CancelBookingSubmit", method = RequestMethod.POST)
	public String cancelBooking(@RequestParam("bookingId") String bookingId, Map<String, Object> model) {
		
			customerService.cancelBooking((BigInteger)session.getAttribute("bookingId"));
	
		return "CustomerPage";

	}

}