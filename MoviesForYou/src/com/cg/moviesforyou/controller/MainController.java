package com.cg.moviesforyou.controller;

import com.cg.moviesforyou.dto.*;
import com.cg.moviesforyou.exception.UserException;
import com.cg.moviesforyou.service.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

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

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage() {
		return "HomePage";
	}

	@RequestMapping(value = "/logInPage", method = RequestMethod.GET)
	public String logInPage() {
		return "LogInPage";
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
	public String addMoviePage(@ModelAttribute("myMovieForm") Movie movie, Map<String, Object> model,HttpServletRequest request) {
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

		request.setAttribute("theatresitem", theatresList);
		model.put("languageDataItem", myLanguageList);
		model.put("genreDataItem", myGenreList);
//		model.put("theatreDataItem", theatres);
		return "AddMoviePage";
	}
	@RequestMapping(value = "/signUpPage", method = RequestMethod.GET)
	public String signUpPage(@ModelAttribute("myCustomerForm") Customer customer, Map<String, Object> model) {

		return "SignUpPage";
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
	@RequestMapping(value = "/addTheatreToDatabase", method = RequestMethod.POST)
	public ModelAndView addTheatre(@ModelAttribute("myTheatreForm") Theatre theatre, BindingResult result) {
		theatreService.save(theatre);
		List<Theatre> myTheatreList = theatreService.findAll();
		return new ModelAndView("ShowTheatrePage", "theatreData", myTheatreList);
	}

	@RequestMapping(value = "/addMovieToDatabase", method = RequestMethod.POST)
	public ModelAndView addMovie(@ModelAttribute("myMovieForm") Movie movie, BindingResult result) {
//		System.out.println("theatres: "+theatresnames);
//		movie.setTheatre(theatre);
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

	@RequestMapping(value = "/validateLogInFromDatabase", method = RequestMethod.POST)
	public ModelAndView validateLogin(@RequestParam("username") String username,
			@RequestParam("password") String password, Map<String, Object> model) throws UserException {
		Customer customer = customerService.validateCustomerLogin(username, password);
		Admin admin = adminService.validateAdminLogin(username, password);

		if (customer != null) {
			model.put("customerData", customer);
			return new ModelAndView("CustomerPage");
		} else if (admin != null) {
			model.put("adminData", admin);
			return new ModelAndView("AdminPage");
		} else {
			return new ModelAndView("InvalidLoginPage");
		}
	}
}