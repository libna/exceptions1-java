package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private int roomNumber;
	private Date checkin;
	private Date checkout;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(int roomNumber, Date checkin, Date checkout) throws DomainException {
		super();
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
		
		if(!checkout.after( checkin)){
			throw new DomainException("reservation: Check-out date must be after check-in date");
		}
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public Date getCheckin() {
		return checkin;
	}
	
	public Date getCheckout() {
		return checkout;
	}
	
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkin,Date checkout) throws DomainException {
		Date now = new Date();
		if(checkin.before(now) || checkout.before(now)) {
			throw new DomainException("Error in reservation: update");
		}if(!checkout.after( checkin)){
			throw new DomainException("reservation: Check-out date must be after check-in date");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return
		"Reservation: "+
		"Room: "+this.roomNumber+
		" checkin: "+sdf.format(this.checkin)
		+", checkout: "+sdf.format(this.checkout)
		+", "+this.duration()+" nights";
	}
}
