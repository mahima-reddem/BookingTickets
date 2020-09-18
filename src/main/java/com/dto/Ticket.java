package com.dto;

//import javax.persistence.Column;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Ticket {
	
	@Id@GeneratedValue
	 private int ticketId;
	 private int noofTickets;
	 //private String seatNo;
	 
	 
	 @ManyToOne (fetch = FetchType.LAZY)
	 @JoinColumn(name = "customerId")
	 
	 private Customer customer;
	 
	 //@OneToOne(targetEntity=Movie.class,cascade=CascadeType.ALL)  
	 
	@OneToOne(fetch = FetchType.LAZY)
			//, cascade = CascadeType.ALL)
	//@PrimaryKeyJoinColumn
	//@Column(unique = true)
	 @JoinColumn(name = "movieId")
	 private Movie movie;


	public Ticket(){
		super();
	}	
	
	


	/*public Ticket(int ticketId, int noofTickets, Customer customer, Movie movie) {
		super();
		this.ticketId = ticketId;
		this.noofTickets = noofTickets;
		this.customer = customer;
		this.movie = movie;
	}*/




	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
   
	public int getNoofTickets() {
		return noofTickets;
	}

	public void setNoofTickets(int noofTickets) {
		this.noofTickets = noofTickets;
	}

	/*public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
  */
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	

}
