package com.cg.moviesforyou.MovieBookSpringBoot.controller; //Controller class

import com.cg.moviesforyou.MovieBookSpringBoot.dto.*;
import com.cg.moviesforyou.MovieBookSpringBoot.exception.UserException;
import com.cg.moviesforyou.MovieBookSpringBoot.service.*;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	BookingService bookingService;
	@Autowired
	HttpSession httpSession;


	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage() {
		return "HomePage";
	}

	@RequestMapping(value = "/logInPage", method = RequestMethod.GET) // Login Page for customer and admin
	public String logInPage() {
		return "LogInPage";
	}

	@RequestMapping(value = "/logOutPage", method = RequestMethod.GET) // Logout
	public String logout() {
		httpSession.setAttribute("username", null);
		return "HomePage";
	}

	@RequestMapping(value = "/addTheatrePage", method = RequestMethod.GET) // Page for adding theatre
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

	@RequestMapping(value = "/addTheatreToDatabase", method = RequestMethod.POST) // Page for adding theatre to database
	public ModelAndView addTheatre(@ModelAttribute("myTheatreForm") Theatre theatre, BindingResult result) {
		theatreService.addTheatre(theatre);
		List<Theatre> myTheatreList = theatreService.findAll();
		httpSession.setAttribute("theatreDataItem", myTheatreList);
		return new ModelAndView("ShowTheatrePage");
	}

	@RequestMapping(value = "/showTheatrePage", method = RequestMethod.GET) // Page for viewing theatres
	public String showTheatrePage(ModelMap model) {
		List<Theatre> myTheatreList = theatreService.findAll();
		httpSession.setAttribute("theatreDataItem", myTheatreList);
		return "ShowTheatrePage";
	}

	@RequestMapping(value = "/addMoviePage", method = RequestMethod.GET) // Page for adding movie
	public String addMoviePage(@ModelAttribute("myMovieForm") Movie movie, Map<String, Object> model) {

		List<String> myLanguageList = new ArrayList<String>();
		List<String> myGenreList = new ArrayList<String>();

		myGenreList.add("Sci-Fi");
		myGenreList.add("Drama");
		myGenreList.add("Thriller");
		myGenreList.add("Comedy");
		myGenreList.add("Romance");
		myGenreList.add("Crime");
		
		myLanguageList.add("Hindi");
		myLanguageList.add("English");
		myLanguageList.add("Marathi");
		myLanguageList.add("Bengali");

		model.put("languageDataItem", myLanguageList);
		model.put("genreDataItem", myGenreList);

		httpSession.setAttribute("theatreDataItem", theatreService.findAll());

		return "AddMoviePage";
	}

	@RequestMapping(value = "/addMovieToDatabase", method = RequestMethod.POST) // Page for adding movie to database
	public ModelAndView addMovie(@ModelAttribute("myMovieForm") Movie movie,
			@RequestParam("movieReleaseDate_id") String movieReleaseDate, @RequestParam("theatre_id") String theatres,
			BindingResult result) {
		try {
			movie.setMovieReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse(movieReleaseDate));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		int[] arr = Arrays.stream(theatres.split(",")).mapToInt(Integer::parseInt).toArray();
		List<Theatre> theatreList = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			theatreList.add(theatreService.findTheatre(arr[i]));
		}
		movie.setTheatre(theatreList);
		movieService.addMovie(movie);
		List<Movie> myMovieList = movieService.findAll();
		httpSession.setAttribute("movieDataItem", myMovieList);
		return new ModelAndView("ShowMoviePage");
	}

	@RequestMapping(value = "/showMoviePage", method = RequestMethod.GET) // Page for viewing movies
	public String showMoviePage() {
		List<Movie> myMovieList = movieService.findAll();
		httpSession.setAttribute("movieDataItem", myMovieList);
		return "ShowMoviePage";
	}
	@RequestMapping(value = "/RemoveMoviePage", method = RequestMethod.GET) // Page for removing movie
	public String removeMoviePage(Map<String, Object> model) {
		List<Movie> myMovieList = movieService.findAll();
		httpSession.setAttribute("movieList", myMovieList);
		return "RemoveMoviePage";
	}

	@RequestMapping(value = "/removeMovieFromDatabase", method = RequestMethod.POST) 
	public ModelAndView removeMovie(@RequestParam("movieId") String movieID) {
		Integer movieId = Integer.parseInt(movieID);
		movieService.removeMovie(movieId);
		List<Movie> myMovieList = movieService.findAll();
		httpSession.setAttribute("movieDataItem", myMovieList);
		return new ModelAndView("ShowMoviePage","message","Movie Removed Successfully");
	}

	@RequestMapping(value = "/addShowPage", method = RequestMethod.GET) // Page for adding show
	public String addShowPage(@ModelAttribute("myShowForm") Show show) {

		List<Movie> myMovieList = movieService.findAll();
		List<Theatre> myTheatreList = theatreService.findAll();
		httpSession.setAttribute("movieDataItem", myMovieList);
		httpSession.setAttribute("theatreDataItem", myTheatreList);
		return "AddShowPage";
	}

	@RequestMapping(value = "/addShowToDatabase", method = RequestMethod.POST) // Page for adding show to database
	public ModelAndView addShow(@ModelAttribute("myShowForm") Show show, @RequestParam("movie_id") String movie_id,
			@RequestParam("showDate_id") String showDate, @RequestParam("showTime_id") String showTime,
			@RequestParam("theatre_id") String theatre_id, BindingResult result) {
		System.out.println(movie_id);
		System.out.println(theatre_id);
		Integer theatreID = Integer.parseInt(theatre_id);
		Integer movieId = Integer.parseInt(movie_id);
		try {
			show.setShowDate(new SimpleDateFormat("yyyy-MM-dd").parse(showDate));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			showTime = showTime + ":00";
			show.setShowTime(new SimpleDateFormat("hh:mm:ss").parse(showTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Theatre theater=new Theatre();
		Movie movie=new Movie();
		theater.setTheatreId(theatreID);
		movie.setMovieId(movieId);
		show.setTheatre(theater);
		show.setMovie(movie);
		showService.addShow(show);
		List<Show> myShowList = showService.findAll();
		return new ModelAndView("ShowShowPage", "showData", myShowList);
	}

	@RequestMapping(value = "/showShowPage", method = RequestMethod.GET) // Page for viewing shows
	public String showShowPage() {
		List<Show> myShowList = showService.findAll();
		httpSession.setAttribute("showData", myShowList);
		return "ShowShowPage";
	}

	//method to remove a movie
	
	@RequestMapping(value = "/showCustomerPage", method = RequestMethod.GET) // Page for showing customers
	public String showCustomerPage(ModelMap model) {
		List<Customer> myCustomerList = customerService.findAll();
		model.addAttribute("customerData", myCustomerList);
		return "ShowCustomerPage";
	}

	@RequestMapping(value = "/signUpPage", method = RequestMethod.GET) // Signup Page for new users
	public String signUpPage(@ModelAttribute("myCustomerForm") Customer customer, Map<String, Object> model) {
		return "SignUpPage";
	}

	@RequestMapping(value = "/addCustomerToDatabase", method = RequestMethod.POST) // Page for adding customer to
																					// database
	public ModelAndView addCustomer(@ModelAttribute("myCustomerForm") Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Error in binding result. ");
		} else {
			try {
				customerService.addCustomer(customer);
			} catch (UserException e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView("HomePage");
	}

	@RequestMapping(value = "/validateLogInFromDatabase", method = RequestMethod.POST) // Method for validating login
	public ModelAndView validateLogin(@RequestParam("username") String username,
			@RequestParam("password") String password) throws UserException {
		Customer customer = null;
		Admin admin = null;
		try {
			customer = customerService.validateCustomerLogin(username, password);
			BigInteger userId=customerService.getUserId(username);
			httpSession.setAttribute("customerId", userId);
			System.out.println(userId);
		} catch (Exception e) {
			
		}
		try {
			admin = adminService.validateAdminLogin(username, password);
		} catch (Exception e) {
			
		}
		if (admin != null) {
			httpSession.setAttribute("adminData", admin);
			httpSession.setAttribute("username", admin.getAdminName());
			return new ModelAndView("AdminPage");
		} else if (customer != null) {
			httpSession.setAttribute("customerData", customer);
			httpSession.setAttribute("username", customer.getCustomerName());
			return new ModelAndView("CustomerPage");
		} else {
			return new ModelAndView("InvalidLoginPage");
		}
	}

	@RequestMapping(value = "/customerPage", method = RequestMethod.GET) // Customer Home Page
	public String customerPage() {
		return "CustomerPage";
	}

	@RequestMapping(value = "/BookingPage", method = RequestMethod.GET) // Page for booking movie tickets
	public String addBookingPage(Map<String, Object> model) {
		model.put("movieList", movieService.findAll());
		return "ChoseMoviePage";
	}

	@RequestMapping(value = "/ChooseMovieSubmit", method = RequestMethod.POST)
	public String chooseTheatreRequest(@RequestParam("movieId") String movieId, Map<String, Object> model) {
		Integer movieID = Integer.parseInt(movieId);
		System.out.println("movie id " + movieID);
		if (movieService.findMovie(movieID) == null) {
			return "ChoseMoviePage";
		} else {
			List<Theatre> theatreList;
			theatreList = movieService.getTheatreByMovieId(movieID);
			if (theatreList.size() > 0) {
				System.out.println("in loop");
				model.put("theatreList", theatreList);
				System.out.println(theatreList.size());
				httpSession.setAttribute("movieId", movieID);
			
				return "ChoseTheatrePage";

			} else {
				model.put("theatresList", theatreList);
				model.put("message", "Sorry, no theatre is currently showcasing this movie.");
				return "ChoseMoviePage";
			}
		}
	}

	@RequestMapping(value = "/choseTheatreSubmit", method = RequestMethod.POST)
	public String chooseShowRequest(@RequestParam("theatreId") String theatreId, Map<String, Object> model) {
		Integer theatreID = Integer.parseInt(theatreId);
		System.out.println("theatre id: " + theatreID);
		Integer movieid = Integer.parseInt(httpSession.getAttribute("movieId").toString());
		System.out.println("movie id: " + movieid);
		List<Show> showsinList;
		showsinList = showService.getShows(movieid, theatreID);

		System.out.println(showsinList);
		if (showsinList.size() > 0) {
			System.out.println("in loop");
			model.put("showsList", showsinList);
			httpSession.setAttribute("theatreId", theatreID);
			
			return "ChoseShowPage";

		} else {
			System.out.println("outside show loop");
			model.put("showsList", showsinList);
			model.put("message", "Sorry, no shows in this theatre .");
			return "ChoseTheatrePage";
		}

	}

	@RequestMapping(value = "/choseShowSubmit", method = RequestMethod.POST)
	public ModelAndView addBookingToDatabase(@RequestParam("showId") String showId,
			@RequestParam("seatsBooked") Integer seatsBooked, Map<String, Object> model) throws Exception {

		Booking booking = new Booking();
		booking.setFlag(0);
		Integer available_seats = showService.getAvailableSeats(Integer.parseInt(showId));
		if (seatsBooked > available_seats) {

			return new ModelAndView("ChoseShowPage", "error", "too many booked seats");
		} else {
			booking.setSeatsBooked(seatsBooked);
			Show show = new Show();
			show.setShowId(Integer.parseInt(showId));
			booking.setShow(show);
			Customer customer = new Customer();
			customer.setCustomerId((BigInteger) (httpSession.getAttribute("customerId")));
			booking.setCustomer(customer);
			booking.setTotalCost(200 * seatsBooked);
			booking.setPayment("Done");
			Booking book=bookingService.addBooking(booking);
			Boolean bookingStatus;
			if(book==null) {
				bookingStatus=false;
			}
			else {
				bookingStatus=true;
			}
			if (bookingStatus == true) {
				BigInteger bookingId = bookingService.getBookingId((BigInteger) (httpSession.getAttribute("customerId")));
				String bookingstatus = "Succesfull! ";
				model.put("bookingId", bookingId);
				httpSession.setAttribute("bookingId", bookingId);
				model.put("bookingId", bookingId);
				showService.updateSeats(Integer.parseInt(showId), available_seats, seatsBooked);
				return new ModelAndView("BookingPage", "bookingstatus", bookingstatus);
			} else {
				String bookingstatus = "Unsuccessfull!";
				return new ModelAndView("BookingPage", "bookingstatus", bookingstatus);
			}
		}
	}

	@RequestMapping(value = "/ViewBookingPage", method = RequestMethod.GET) // Page for viewing booking
	public ModelAndView getAllBookings() {
		List<Booking> bookings = bookingService.viewBookings((BigInteger) (httpSession.getAttribute("customerId")));
		return new ModelAndView("ViewBookingPage", "data", bookings);
	}

	@RequestMapping(value = "/CancelBooking", method = RequestMethod.GET) // Page for cancelling booking
	public ModelAndView cancelBookingPage(Map<String, Object> model) {
		List<Booking> bookings = bookingService.viewBookings((BigInteger) httpSession.getAttribute("customerId"));
		model.put("bookings", bookings);
		return new ModelAndView("CancelBooking", "data", bookings);
	}

	@RequestMapping(value = "/CancelBookingSubmit", method = RequestMethod.POST)
	public String cancelBooking(@RequestParam("bookingId") String bookingId, Map<String, Object> model) {
		
		bookingService.cancelBooking(new BigInteger(bookingId));
		return "CustomerPage";

	}

}