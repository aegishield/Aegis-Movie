package com.aegis.webapp.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aegis.webapp.entities.AppUser;
import com.aegis.webapp.entities.Booking;
import com.aegis.webapp.entities.Branch;
import com.aegis.webapp.entities.HourDetail;
import com.aegis.webapp.entities.Movie;
import com.aegis.webapp.entities.Room;
import com.aegis.webapp.repository.AppUserRepository;
import com.aegis.webapp.repository.BookingRepository;
import com.aegis.webapp.repository.BranchRepository;
import com.aegis.webapp.repository.HourRepository;
import com.aegis.webapp.repository.MovieRepository;
import com.aegis.webapp.repository.RoomRepository;

@Controller
public class BookingController {
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	AppUserRepository appUserRepository;
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	HourRepository hourRepository;
	
	@RequestMapping(value = "/transaction", method = RequestMethod.GET)
	public String myTransactionPage(Model model,Principal principal,@RequestParam(value = "transaction",required = false) Long bookingId,@RequestParam(value="booking",required = false) Long detailId,RedirectAttributes redirectAttrs ) {
		User loginedUser = (User) ((Authentication) principal).getPrincipal();
        AppUser user = appUserRepository.findByUserName(loginedUser.getUsername());
        model.addAttribute("detail",detailId);
        model.addAttribute("transaction",bookingId);
        if(detailId == null) {
        	List<Booking> books = bookingRepository.findAllByUserId(user.getUserId());
        	model.addAttribute("books",books);
        }
        
        if(bookingId != null) {
        	Booking book = bookingRepository.findByBookingId(bookingId);
        	if(book!= null) {
	        	if(user.getUserId() != book.getUserId()) {
	        		model.addAttribute("error","Something went wrong");
	        		return "transactionPage";
	        	} else {
	        		bookingRepository.delete(book);
	        		Room room = roomRepository.findByRoomId(book.getRoomId());
	        		Integer conpensation = room.getPrice() * 8 / 100;
	        		user.setBalance(user.getBalance() + conpensation);
	        		appUserRepository.save(user);
	                redirectAttrs.addFlashAttribute("success","Your booking is successfully deleted with booking id : " + book.getBookingId());
	        		return "redirect:/transaction";
	        	}
        	} else {
        		model.addAttribute("error","Something went wrong");
        	}
        }
        
        if(detailId != null) {
        	Booking book = bookingRepository.findByBookingId(detailId);
        	Movie movie = movieRepository.findByMovieId(book.getMovieId());
        	HourDetail hour = hourRepository.findByHourId(book.getHourId());
        	Room room = roomRepository.findByRoomId(book.getRoomId());
        	Branch branch = branchRepository.findByBranchId(room.getBranchId());
        	model.addAttribute("branch",branch);
        	model.addAttribute("books",book);
        	model.addAttribute("movie",movie);
        	model.addAttribute("hour",hour);
        	model.addAttribute("room",room);
        }
        return "transactionPage";
    }
	
	@RequestMapping(value = "/booking", method = RequestMethod.GET)
	public String bookingPage(Model model,@RequestParam(value = "movie",required = false) Long movieId,@RequestParam(value = "branch",required = false) Long branchId,Booking booking,Principal principal,Branch branch) {
        model.addAttribute("booking",booking);
        model.addAttribute("movieId",movieId);
        model.addAttribute("branchId",branchId);
        List<HourDetail> hours = hourRepository.findAll();
        model.addAttribute("hours",hours);
		if(movieId != null) {
			Movie movie = movieRepository.findByMovieId(movieId);
			model.addAttribute("movie",movie);
		}
		if(branchId == null) {
			List<Branch> branches = branchRepository.findAllByStatus(true);
			model.addAttribute("branches",branches);
		} else {
			List<Room> rooms = roomRepository.findAllByBranchIdAndStatus(branchId,true);
			model.addAttribute("rooms",rooms);
		}
        return "bookingPage";
    }
	
	@RequestMapping(value = "/booking", method = RequestMethod.POST)
	public String saveBooking(Model model,Principal principal,Booking booking,BindingResult bindingResult,@RequestParam(value = "movie",required = false) Long movieId,RedirectAttributes redirectAttrs){
		User loginedUser = (User) ((Authentication) principal).getPrincipal();
        AppUser user = appUserRepository.findByUserName(loginedUser.getUsername());
        Booking bookingExists = bookingRepository.findByBookingDateAndHourIdAndRoomId(booking.getBookingDate(), booking.getHourId(), booking.getRoomId());
        
        if(bookingExists == null) {
        	
        	Room bookingRoom = roomRepository.findByRoomId(booking.getRoomId());
        	Integer myBalance = user.getBalance();
        	Integer bookingPrice = bookingRoom.getPrice();
        	
        	if(myBalance < bookingPrice) {
        		bindingResult.reject("balanceNotEnough");
        		model.addAttribute("error","Balance insufficient! Please add your balance in our Aegis Movie outlet!");
        		return "bookingPage";
        	}
        	
        	Date now = new Date();
        	booking.setTransactionDate(now);
        	booking.setUserId(user.getUserId());
        	booking.setMovieId(movieId);
        	booking.setStatus(false);
        	user.setBalance(user.getBalance() - bookingPrice);
        	appUserRepository.save(user);
        	bookingRepository.save(booking);
            redirectAttrs.addFlashAttribute("success","Your booking is successfully saved with booking id : " + booking.getBookingId() + "  Please confirm your booking in our Aegis Movie outlet!");
        } else {
        	bindingResult.reject("bookingExists");
        	model.addAttribute("error","Booking already exists! Please check booking schedule for empty schedule!");
        	return "bookingPage";
        }
        return "redirect:/transaction";
    }
	
	@RequestMapping(value = "/booking/movie", method = RequestMethod.GET)
    public String listAllMovie(Model model,@RequestParam (value = "search", required = false) String search) {
		if(search != null) {
			Movie movie = movieRepository.findByMovieName(search);
			model.addAttribute("movies",movie);
		} else {
			List<Movie> movies = movieRepository.findAllByStatus(true);
			model.addAttribute("movies",movies);
		}
		return "bookMovie";
	}
	
}
