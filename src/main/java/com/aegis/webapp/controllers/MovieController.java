package com.aegis.webapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aegis.webapp.entities.Movie;
import com.aegis.webapp.repository.MovieRepository;

@Controller
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepository;

	@RequestMapping(value = "admin/movie", method = RequestMethod.GET)
    public String listAllMovie(Model model,	@RequestParam(value = "id",required = false) Long id,@RequestParam(value = "status",required = false) boolean status) {
		try {
			Movie movie = movieRepository.findByMovieId(id);
			movie.setStatus(status);
			movieRepository.save(movie);
		} catch(NullPointerException e) {
			
		}
    	List<Movie> movies = movieRepository.findAll();
    	model.addAttribute("movies",movies);
    	return "movieList";
    }
	
	@RequestMapping(value = "admin/movie/add", method = RequestMethod.GET)
    public String showAddMoviePage(Model model,Movie movie) {
    	
    	model.addAttribute("movie",movie);
    	return "movieAdd";
    }
	
	@RequestMapping(value = "admin/movie/add", method = RequestMethod.POST)
    public String saveMovie(Model model,@ModelAttribute("movie") Movie movie,BindingResult bindingResult,HttpServletRequest request) {
    	Movie movieExists = movieRepository.findByMovieName(movie.getMovieName());
    	if(movieExists != null) {
			model.addAttribute("movieFound", "Oops! Movie already in database!");
			bindingResult.reject("movieName");
		} else {
			model.addAttribute("messageSuccess", "Movie sucessfully added!");
			movie.setStatus(true);
			movieRepository.save(movie);
		}
    	return "movieAdd";
    }
	
	@RequestMapping(value="/admin/movie/edit/{id}", method = RequestMethod.GET)
	public String showEditMoviePage(Model model,Movie movie,@PathVariable("id") Long id){
		movie = movieRepository.findByMovieId(id);
		if (movie == null) {
			return "errorPage";
		}
		model.addAttribute("movie",movie);
		return "movieEdit";
	}
	
	@RequestMapping(value="/admin/movie/edit/{id}", method = RequestMethod.POST)
	public String postEditMovie(Model model,Movie movie,@PathVariable("id") Long id){
			model.addAttribute("messageSuccess", "Edit Successfull!");
			movieRepository.save(movie);
			return "movieEdit";
	}
}
