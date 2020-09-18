package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.db.HibernateTemplate;
import com.dto.Ticket;

public class TicketDAO {
	
private SessionFactory factory = null;
	
	/*public Ticket getCustomerByName(String custName, String custPassword){
		return (Customer)HibernateTemplate.getObjectByName(custName, custPassword);
	}*/
    
	
	public int register(Ticket ticket) {		
		return HibernateTemplate.addObject(ticket);
	}
	
	public Ticket getTicketByCustomerId(int id) {
		return (Ticket)HibernateTemplate.getTicketByCustomerId(id);
	} 
	
	public List<Ticket> getAllTickets(){
		List<Ticket> tickets = (List)HibernateTemplate.getObjectListByQuery("from Ticket");
		System.out.println("Inside All Tickets ..."+tickets);
		return tickets;
	}
	
	public int editTicket(Ticket ticket){
		return HibernateTemplate.updateObject(ticket);
	}
	
	public int deleteTicket(int ticketId){
		return HibernateTemplate.deleteObject(Ticket.class, ticketId);
	}


}
