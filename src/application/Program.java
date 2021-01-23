package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Room number");
		int roomNumber = sc.nextInt();
		
		sc.nextLine();
		System.out.println("Check-in date (dd/MM/yyyy)");
		Date checkin = sdf.parse(sc.nextLine());
		System.out.println("Check-in date (dd/MM/yyyy)");
		Date checkout	 = sdf.parse(sc.nextLine());
		
		if(!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}else {
			Reservation reserva = new Reservation(roomNumber,checkin,checkout);
			System.out.println(reserva);
			
			System.out.println();
			System.out.println("Check-in date (dd/MM/yyyy)");
			checkin = sdf.parse(sc.nextLine());
			System.out.println("Check-out date (dd/MM/yyyy)");
			checkout	 = sdf.parse(sc.nextLine());
			
			Date now = new Date();
			if(checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation: update");
			}else if(!checkout.after(checkin)){
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}else {
				reserva.updateDates(checkin, checkout);
				System.out.println(reserva);
			}
		}
		
		
		
		
		
		
		sc.close();
	}
}
