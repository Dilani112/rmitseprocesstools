package rmitseprocesstools.controller;

import java.util.ArrayList;
import rmitseprocesstools.view.AddBookingView;
import java.util.List;
import rmitseprocesstools.DbHandler;
import rmitseprocesstools.model.Booking;
import rmitseprocesstools.model.Customer;
import rmitseprocesstools.model.Schedule;
import rmitseprocesstools.model.BookingStatus;

public class BookingController {
    
    public void displayAddBookingView()
    {
        AddBookingView view = new AddBookingView();        
        view.setVisible(true);        
    }
  
    public static List<String> setCustomerNameList() {
            
        List<String> nameList = new ArrayList<String>();
        List<Customer> customerList = DbHandler.GetCustomers();
        
        customerList.forEach((customer) -> {
            nameList.add(customer.Name);
        });
        
        return nameList;
    
    }
    
    
    public static List<String> setScheDuleTimeListValues() {
           
        List<String> DateTimeList = new ArrayList<String>();
        List<Schedule> scheduleList = DbHandler.GetSchedules();
        
        scheduleList.forEach((schedule) -> {
          
        DateTimeList.add(schedule.StartDateTime.toLocalDate().toString()
                +"  " +schedule.StartDateTime.toLocalTime().toString()
                + " - "+ schedule.EndDateTime.toLocalTime().toString());
        });
        
        return DateTimeList;    
    }

    
   public String getCustomerPhoneByName(String name) {
        
       String phone =null;
       
       List<Customer> customerList = DbHandler.GetCustomers();
        
        for(Customer customer:customerList){
            
            if(name.equals(customer.Name))
            {
                phone=  customer.Phone;
            }            
        }        
        return phone;    
   }
   
   
   public void saveBookingMade(String name, String pmade, String pfor, BookingStatus status){
       
       Booking newBooking  = new Booking();
            
       newBooking.PersonFor = name;
       newBooking.PersonMade = name;
       newBooking.Status = status;
       
       DbHandler.SaveBooking(newBooking);               
   }
   
   
}