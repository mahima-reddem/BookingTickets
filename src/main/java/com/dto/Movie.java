package com.dto;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class Movie {
	
	@Id@GeneratedValue
	private int movieId;
	private String movieName;
	private int movieRating;
	private String movieDate;
	private String movieTime;
	private int seatsRemaining;
	
	/*@OneToOne(mappedBy="movie")//(targetEntity=Ticket.class)
	private Ticket ticket;*/
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "movie")
			//, cascade = CascadeType.ALL)
	//fetch = FetchType.LAZY, mappedBy = "movie", cascade = CascadeType.ALL
	//@Fetch(value=FetchMode.SUBSELECT)
	private Ticket ticket;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "theatreId")
	private Theatre theatre;
	
	
	
	
	public Movie(){
		super();
	}
	
	

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}
	
	

	public String getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}

	public String getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}

	public int getSeatsRemaining() {
		return seatsRemaining;
	}

	public void setSeatsRemaining(int seatsRemaining) {
		this.seatsRemaining = seatsRemaining;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	
	
	/*public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}*/


	


}
