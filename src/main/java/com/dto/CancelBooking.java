package com.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CancelBooking {
	
	private LocalDate currentDate;
	private LocalTime currentTime;
	private boolean cancelStatus;
	private double refund;
	
	public CancelBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public boolean isCancelStatus() {
		return cancelStatus;
	}

	public void setCancelStatus(boolean cancelStatus) {
		this.cancelStatus = cancelStatus;
	}

	public LocalDate getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
	}

	public LocalTime getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(LocalTime currentTime) {
		this.currentTime = currentTime;
	}
	
	
	public double getRefund() {
		return refund;
	}

	public void setRefund(double refund) {
		this.refund = refund;
	}

}
