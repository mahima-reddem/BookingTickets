package com.ts;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.CancelBookingDAO;
import com.dao.CustomerDAO;
import com.dao.MovieDAO;
import com.dao.PaymentDAO;
import com.dao.TheatreDAO;
import com.dao.TicketDAO;
import com.dao.emailSending;
import com.dto.CancelBooking;
import com.dto.Customer;
import com.dto.Movie;
import com.dto.Payment;
import com.dto.Theatre;
import com.dto.Ticket;

@Path("myresource")
public class MyResource {

   
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @Path("Hi")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHi() {
        return "Hi Resource!";
    }
    
    @Path("registerCustomer1")
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
    public String registerCustomer1(){
    	Customer customer = new Customer();
    	customer.setCustomerId(1);
    	customer.setCustName("Harsha");
    	customer.setCustMobileno("9700251531");
    	customer.setCustEmail("sreeharsha.1210@gmail.com");
    	customer.setOtp(1234);
    	
    	CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.register(customer);
		System.out.println("Customer Registeredd!!");
		return "Success";
    	
    }
    
    
    @Path("registerCustomer")
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
    public Customer registerCustomer(Customer customer){
    	CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.register(customer);
		System.out.println("Customer added!!");
		return customer;
    	
    }
    
    
    @Path("registerTicket")
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
    public Ticket registerTicket(Ticket ticket){
    	System.out.println("Ticket choosed : " + ticket);
    	TicketDAO ticketDAO = new TicketDAO();
		ticketDAO.register(ticket);
		//System.out.println("Ticket Choosed!!");
		return ticket;
    	
    }

    
	
	@Path("registerTheatre")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Theatre registerTheatre(Theatre theatre){
		System.out.println("Theatre added!! " + theatre);
    	TheatreDAO theatreDAO = new TheatreDAO();
		theatreDAO.register(theatre);
		//System.out.println("Theatre added!!");
		return theatre;
	
    }
    	
	
	@Path("registerMovie")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Movie registerMovie(Movie movie){
		MovieDAO movieDAO = new MovieDAO();
		movieDAO.register(movie);
		System.out.println("Movie added!!");
		return movie;
	}
	
	
	
	@Path("getAllCustomers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getAllCustomers(){
		System.out.println("In get all customers");
		List<Customer> customers = new ArrayList<Customer>();
		CustomerDAO customerDAO = new CustomerDAO();
		customers = customerDAO.getAllCustomers();
		System.out.println(customers);
		return customers;
	}
	
	
	@Path("getAllTickets")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ticket> getAllTickets(){
		System.out.println("In get all tickets");
		List<Ticket> tickets = new ArrayList<Ticket>();
		TicketDAO ticketDAO = new TicketDAO();
		tickets = ticketDAO.getAllTickets();
		//System.out.println(tickets);
		return tickets;
	}
	
	@Path("getAllTheatres")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Theatre> getAllTheatres(){
		List<Theatre> theatres = new ArrayList<Theatre>();
		TheatreDAO theatreDAO = new TheatreDAO();
		theatres = theatreDAO.getAllTheatres();
		return theatres;
	}
	
	@Path("getAllMovies")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getAllMovies(){
		List<Movie> movies = new ArrayList<Movie>();
		MovieDAO movieDAO = new MovieDAO();
		movies = movieDAO.getAllMovies();
		return movies;
	}
	
	@Path("getCustomer/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@PathParam("id") int id){
		Customer customer = new Customer();
		CustomerDAO customerDAO = new CustomerDAO();
		customer = customerDAO.getCustomer(id);
		return customer;
	}
	
	@Path("getTicketByCustomerId/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Ticket getTicket(@PathParam("id") int id){
		Ticket ticket = new Ticket();
		TicketDAO ticketDAO = new TicketDAO();
		ticket = ticketDAO.getTicketByCustomerId(id);
		return ticket;
		
	}
	
	@Path("getMovie/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Movie getMovie(@PathParam("id") int id){
		Movie movie = new Movie();
		MovieDAO movieDAO = new MovieDAO();
		movie = movieDAO.getMovie(id);
		return movie;
	}
	
	
	@Path("updateTheatre")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void updateTheatre(Theatre theatre){
		TheatreDAO theatreDAO = new TheatreDAO();
		int result = theatreDAO.editTheatre(theatre);
		
	}
	
	@Path("getMoviesByTheatreId/{theatreId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getMoviesByTheatreId(@PathParam("theatreId") int theatreId){
		/*int theatreId;
		String words[];
		words = details.split(" ");
		theatreId = Integer.parseInt(words[0]);*/
		//System.out.println("Get movies " + );
		List<Movie> movies = new ArrayList<Movie>();
		MovieDAO movieDAO = new MovieDAO();
		movies = movieDAO.getMoviesByTheatreId(theatreId);
		return movies;
	}
	
	@Path("bookTicket/{details}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String bookTicket(@PathParam("details") String details){
		int movieId,noOfTickets;
		String words[];
		words = details.split(" ");
		
		movieId = Integer.parseInt(words[0]);
		noOfTickets = Integer.parseInt(words[1]);
		
		Movie movie = new Movie();
		MovieDAO movieDAO = new MovieDAO();
		movie = movieDAO.getMovie(movieId);
		
		/*Theatre theatre = new Theatre();
		TheatreDAO theatreDAO = new TheatreDAO();
		theatre = theatreDAO.getTheatre(theatreId);
		Show show = new Show();
		ShowDAO showDAO = new ShowDAO();
		
		
		movie.setTheatre(theatre);*/
		
		movie.setSeatsRemaining(movie.getSeatsRemaining()-noOfTickets);
		
		System.out.println("Your seat is booked for the Show!!");
		return "Your seat is allocated for the show!!";
		
		
	}
	
	@Path("generateOTP/{customerId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public int generateOTP(@PathParam("customerId") int customerId){
		Customer customer = new Customer();
		CustomerDAO customerDAO = new CustomerDAO();
		customer = customerDAO.getCustomer(customerId);
		emailSending emailsending = new emailSending();
		int otp = emailsending.generateOtp(customer);
		return otp;
		
	}
	
	
	@Path("confirmPayment")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Payment confirmPayment(Ticket ticket){
		System.out.println(ticket);
		System.out.println("Payment");
		PaymentDAO paymentDAO = new PaymentDAO();
		return paymentDAO.paymentConfirmation(ticket);
	}
	
	@Path("cancelTicketBooking/{details}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public CancelBooking cancelTicketBooking(@PathParam("details") String details){
		int showId,ticketId;
		String words[];
		words = details.split(" ");
		
		showId = Integer.parseInt(words[0]);
		ticketId = Integer.parseInt(words[1]);
		//Show show = new Show();
		
		CancelBookingDAO cancelBookingDAO = new CancelBookingDAO();
		 return cancelBookingDAO.cancelTicket(ticketId, showId);
		
	}
	
	
    
    
}
