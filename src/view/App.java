package view;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.AuthController;
import controller.BookingController;
import model.Booking;
import model.Schedule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("WELCOME TO THE APPOINTMENT BOOKING SYSTEM");
        System.out.println("\nPlease Select one of these options to continue:\n1. Login\n2. Register\n0. Quit");
        int option = in.nextInt();

        switch(option){
            case 1:{
                String email,password;
                System.out.print("Please enter your email: ");
                email = in.next();
                System.out.print("Please enter your password: ");
                password = in.next();
                if(AuthController.login(email,password)) showMenu(in);
                break;
            }
            case 2: {
                System.out.println("Please enter the following info to register:");

                System.out.print("\nEmail: ");
                Scanner next = new Scanner(System.in);
                String email = next.nextLine();
                System.out.print("Password: ");
                String password = next.nextLine();
                System.out.print("Name: ");
                String name = next.nextLine();
                System.out.print("Address: ");
                String address = next.nextLine();
                System.out.print("Contact Number: ");
                String phone = next.nextLine();
                System.out.print("Secret Question: ");
                String q = next.nextLine();
                System.out.print("Answer: ");
                String a = next.nextLine();
                if(AuthController.register(email,password,name,address,phone,q,a)) showMenu(in);
                break;
            }
            case 0: {
                System.out.println("Bye");
                System.exit(0);
            }
        }
    }
  
    public static void showMenu(Scanner in) {
        
        while(true)
        {
        	System.out.println("\nMain Menu");
            System.out.println("_____________");
            System.out.println("What are you going to do today?\n\n1. View Available Time\n2. Booking/Cancel\n3. View Your Booking Time\n");

        	boolean status = false;
        	int selection=in.nextInt();
        switch(selection){
            case 1:
                do{
                    status = viewAvailability(in);
                }while(!status);
                break;

            case 2:
                do{
                    status = bookingCancel(in);
                }while(!status);
                break;

            case 3:
                viewBooking(in);
                break;
        }
        }
    }
    
    public static boolean viewAvailability(Scanner in){
    	in.nextLine();
        System.out.println("Which date do you want to check availability for?");
        System.out.println("Please use the format dd/MM/yyyy eg. 14/04/2017");
        String dateIn = in.nextLine();
            
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ld = LocalDate.parse((CharSequence)dateIn, dtf);
            
        List<Schedule> schedules = BookingController.getFreeSchedulesForDate(ld);

        if (schedules.isEmpty()){
            System.out.println("No vacant timeslots available");
            return true;
        }

        System.out.println("These timeslots are vacant on " + ld.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH) + " " + ld.format(dtf) + ":");
        for (Schedule s : schedules) {
          	String startTime = s.StartDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"));
            String endTime = s.EndDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"));

           	System.out.println(startTime + " - " + endTime);
		}
        return true;
    }
    
    public static boolean bookingCancel(Scanner in){
    	in.nextLine();
        System.out.println("Which date do you want to check availability for?");
        System.out.println("Please use the format dd/MM/yyyy eg. 14/04/2017");
        String dateIn = in.nextLine();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ld = LocalDate.parse((CharSequence)dateIn, dtf);

        if(ld.isBefore(LocalDate.now())){
            System.out.println("Can't book an appointment for a date in the past");
            return false;
        }

        List<Schedule> schedules = BookingController.getFreeSchedulesForDate(ld);
        int[] arr = new int[100];
        int ind = 0;
        System.out.println("These timeslots are vacant on " + ld.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH) + " " + ld.format(dtf) + ":");
        for (Schedule s : schedules) {
        	String startTime = s.StartDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"));
            String endTime = s.EndDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"));
        	System.out.println(s.ScheduleId + " | " + startTime + " - " + endTime);
        	arr[ind] = s.ScheduleId;
        	ind++;
		}
        System.out.println("Please select one of these timeslots by entering the number preceding the start time.");
        
        boolean status = false;
        while(!status)
        {
        	int scheduleIdIn = in.nextInt();
        	if(scheduleIdIn != 0)
        	{
        	    for(int v = 0; v<arr.length;v++){
        	        if(arr[v] == scheduleIdIn){
        	            continue;
                    }else {
        	            System.out.println("Invalid Input");
        	            return false;
                    }
                }
        		BookingController ctrl = new BookingController();
            	status = ctrl.saveBookingMade(AuthController.getActiveUser().CustomerId, scheduleIdIn);
            	if(!status)
            		System.out.println("Invalid input or a Double Booking. Please try again or input 0 to cancel.");
        	}else{
        		break;
        	}
        }
        
        return true;
    }
    
    public static void viewBooking(Scanner in){
    	in.nextLine();
    	List<Schedule> schedules = BookingController.getBookedSchedulesByCustomerId(AuthController.getActiveUser().CustomerId);


        if(schedules.isEmpty()){
            System.out.println("No bookings available");
            return;
        }

        System.out.println("Here are the timeslots that you've booked: ");

        for (Schedule s : schedules) {
            if (s != null) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String date = s.StartDateTime.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH) + " " + s.StartDateTime.format(dtf);
                String startTime = s.StartDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"));
                String endTime = s.EndDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"));

                System.out.println(date + " " + startTime + " - " + endTime);
            }
		}
        
        in.nextLine();
    }
    
}
