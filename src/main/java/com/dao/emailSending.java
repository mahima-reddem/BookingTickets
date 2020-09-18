package com.dao;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.dto.Customer;
import com.dto.Movie;
import com.dto.Theatre;
import com.dto.Ticket;

public class emailSending {
	
	public int generateOtp(Customer customer){
		int randomPin = (int)(Math.random()*9000)+1000;
		String otp = String.valueOf(randomPin);
		
		final String username = "bookingtickets2020@gmail.com";
		final String password = "bookingtickets";
		
		String sendMessage = "Hi "+ customer.getCustName() + "!\nHere is the OTP : " + otp + "for the confirmation of your booking. ";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
	      
	      Session sessionobj = Session.getInstance(prop,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
		   }
	         });

	      try {
		   
		   Message message = new MimeMessage(sessionobj);
		   message.setFrom(new InternetAddress("bookingtickets2020@gmail.com"));
           message.setRecipients(
                   Message.RecipientType.TO,
                   InternetAddress.parse(customer.getCustEmail())
           );
           message.setSubject("OTP mail.. ");
           message.setText(sendMessage);
		   Transport.send(message);
		   
		   System.out.println("Your email sent successfully....");
	      } 
	      catch (MessagingException e) {
	         e.printStackTrace();
	      }
	      return Integer.parseInt(otp);
	}
	
	public void sendEmail(Customer customer,Ticket ticket, Theatre theatre, Movie movie){
		
		System.out.println("Mail Sending...");
		
		final String username = "bookingtickets2020@gmail.com";
		final String password = "bookingtickets";
		
		String setMessage = "Hi " + customer.getCustName() + "!\nYour tickets are booked!!\nDetails are:\n"
				+ "\nTheatre Name :" + theatre.getTheatreName() + "\n" +
				"Movie Name : " + movie.getMovieName() + "\n" +
				"movie : " + movie.getMovieDate() + "\n" +
				"movie Timings : " + movie.getMovieTime() + "\n" +
				"No.of Tickets Booked : " + ticket.getNoofTickets() + "\n" +
				"Have a nice day:)\n\nThank you for choosing Booking Tickets.";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
	      
	      Session sessionobj = Session.getInstance(prop,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
		   }
	         });

	      try {
		   
		   Message message = new MimeMessage(sessionobj);
		   message.setFrom(new InternetAddress("bookingtickets2020@gmail.com"));
           message.setRecipients(
                   Message.RecipientType.TO,
                   InternetAddress.parse(customer.getCustEmail())
           );
           message.setSubject("OTP mail.. ");
           message.setText(setMessage);
		   Transport.send(message);
		   
		   System.out.println("Your email sent successfully....");
	      } 
	      catch (MessagingException e) {
	         e.printStackTrace();
	      }
	}


}
