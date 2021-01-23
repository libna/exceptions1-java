package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Room number");
			int roomNumber = sc.nextInt();
			
			sc.nextLine();
			System.out.println("Check-in date (dd/MM/yyyy)");
			Date checkin = sdf.parse(sc.nextLine());
			System.out.println("Check-in date (dd/MM/yyyy)");
			Date checkout	 = sdf.parse(sc.nextLine());
			
		
			Reservation reserva = new Reservation(roomNumber,checkin,checkout);
			System.out.println(reserva);
			
			System.out.println();
			System.out.println("Check-in date (dd/MM/yyyy)");
			checkin = sdf.parse(sc.nextLine());
			System.out.println("Check-out date (dd/MM/yyyy)");
			checkout	 = sdf.parse(sc.nextLine());
			
			reserva.updateDates(checkin, checkout);
			System.out.println("reserva:"+ reserva);
			
		}catch (ParseException e) {
			System.out.println("Invalid date format");
		}catch (DomainException e) {
			System.out.println("Error in reservation " + e.getMessage());
		}
		
 
		sc.close();
	}
}
