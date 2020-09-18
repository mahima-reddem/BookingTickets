package com.dao;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import com.dto.CancelBooking;
import com.dto.Movie;

public class CancelBookingDAO {
	
	public CancelBooking cancelTicket(int ticketId, int movieId){
		CancelBooking cancelBooking = new CancelBooking();
		Movie movie = new Movie();
		MovieDAO movieDAO = new MovieDAO();
		movie = movieDAO.getMovie(movieId);
				
		cancelBooking.setCurrentDate(LocalDate.now(ZoneId.systemDefault()));
		cancelBooking.setCurrentTime(LocalTime.now(ZoneId.systemDefault()));
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
	    String strDate = formatter.format(cancelBooking.getCurrentDate());
	    
	    /*formatter= new SimpleDateFormat("hh:mm:ss"); 
	    String strTime = formatter.format(cancelBooking.getCurrentDate());*/
	    
	    if(strDate.compareTo(movie.getMovieDate()) < 0){
	    	System.out.println("You can cancel only one ticket at a time...");
	    	System.out.println("Only 60% of amount will be refunded!!");
	    	
	    	cancelBooking.setCancelStatus(true);
	    	cancelBooking.setRefund(600*(60/100));
	    	TicketDAO ticketDAO = new TicketDAO();
	    	ticketDAO.deleteTicket(ticketId);
	    	movie.setSeatsRemaining(movie.getSeatsRemaining()+1);
	    }
	    else{
	    	cancelBooking.setCancelStatus(false);
	    	cancelBooking.setRefund(0);
	    }
	    
	    
	    return cancelBooking;
	}

}
