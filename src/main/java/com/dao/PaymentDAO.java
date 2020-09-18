package com.dao;

import com.dto.Payment;
import com.dto.Ticket;

public class PaymentDAO {
	
	public Payment paymentConfirmation(Ticket ticket){
		Payment payment = new Payment();
		payment.setAmount(600);
		payment.setTotal(payment.getAmount() * ticket.getNoofTickets());
		
		
		return payment;
		
	}

}
