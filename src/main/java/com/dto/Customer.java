package com.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@XmlRootElement
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "ticketId")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Customer {
	
	@Id@GeneratedValue
	private int customerId;
	private String custName;
	private String custMobileno;
	private String custEmail;
	private int otp;
	
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	 @Fetch(value = FetchMode.SUBSELECT)
	private List<Ticket> ticketList =new ArrayList<Ticket>();
	
	
	public Customer() {
		super();
	}
	
	

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustMobileno() {
		return custMobileno;
	}

	public void setCustMobileno(String custMobileno) {
		this.custMobileno = custMobileno;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}


}
