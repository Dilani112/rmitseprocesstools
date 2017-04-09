package view;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.AuthController;

import java.util.Scanner;

public class App {
    
    public static void main(String[] args){

        // Controller objects
        AuthController authCtrl = new AuthController();
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
                if(authCtrl.login(email,password)) showMenu(in);
                break;
            }
            case 2: {
                System.out.println("Please enter the following info to register:");

                System.out.print("\nEmail: ");
                Scanner next = new Scanner(System.in);
                String email = next.nextLine();
                System.out.print("Name: ");
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
                if(authCtrl.register(email,password,name,address,phone,q,a)) showMenu(in);
                break;
            }
            case 0: {
                System.out.println("Bye");
                System.exit(0);
            }
        }
    }
  
    public static void showMenu(Scanner in) {
        System.out.println("\nMain Menu");
        System.out.println("_____________");
        System.out.println("What are you going to do today?\n\n1. View Available Time\n2. Booking/Cancel\n3. View Your Booking Time\n");

        int selection=in.nextInt();
        switch(selection){
            case 1:
                boolean status = false;
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
    public static boolean viewAvailability(Scanner in){
        System.out.println("What kind of business are you looking for?");
        in.nextLine();
        if(true){ //has to change the controller when assigned
            System.out.println("Here are a list of businesses that match your description. Please select one:");
            System.out.println("Hairdresser, restaurant, library ...");//.....list of businesses
            in.nextLine();
            System.out.println("Which day do you want to check availability for?");
            in.nextLine();
            System.out.println("Monday, 9:30-10:30,\tBOOKED\n.");//.....list of available time
            return true;
        }
        else{
            System.out.print("Sorry, we didn't find anything that matches your description. Please try again!");
        }   return false;
    }
    
    public static boolean bookingCancel(Scanner in){
        System.out.println("What kind of business are you booking for?");
        in.nextLine();
        if(true){ //has to change the controller when assigned
            System.out.println("Here are a list of businesses that match your description. Please select one:");
            System.out.println("Hairdresser, restaurant, library ...");//.....list of businesses
            in.nextLine();
            System.out.println("Please select your employee: ");
            System.out.println("James, David, Cassey..."); //list of employees
            in.nextLine();
            System.out.println("Here are his/her availability for <day>:");
            System.out.println("Monday, 9:30-10:30,\tBOOKED\n.");//.....list of available time
            System.out.println("Which slots do you want to book for?");
            System.out.println("Wednesday, 10:30-11:30,\tAVAILABLE\n.");//.....list of available time
            in.nextLine();
            if(true){
                System.out.println("Thank you! You have booked your slot!");
                in.nextLine();
            }else{
                System.out.println("Sorry, please try again!");
                in.nextLine();
            }
            return true;
        }
        else{
            System.out.print("Sorry, we didn't find anything that matches your description. Please try again!");
        }   return false;
    }
    
    public static void viewBooking(Scanner in){
        System.out.println("Here is the slot that you've booked for: ");
        System.out.println("Wednesday, 10:30-11:30,\tBOOKED\n.");
        in.nextLine();
    }
    
}
