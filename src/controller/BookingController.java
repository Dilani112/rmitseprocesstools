package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.swing.JOptionPane;
import controller.DbHandler;
import model.Booking;
import model.Customer;
import model.Schedule;
import model.User;
import model.BookingStatus;

public class BookingController {
	
    public static List<String> setCustomerNameList() {
        
        List<String> nameList = new ArrayList<String>();
        List<Customer> customerList = DbHandler.GetCustomers();
        BookingController controller = new BookingController();
        
        if(controller.checkCurrentUserIsCustomer(AuthController.getActiveUser()))
        {
            String name = controller.getCustomerNameByUsername(AuthController.getActiveUser().Username); 
            nameList.add(name);
        
        }else {
            customerList.forEach((customer) -> {
            nameList.add(customer.Name + " [ID - "+customer.CustomerId+" ]");
            });
        }
               
        return nameList;
    
    }
       
    public static List<String> getScheduleTimeListValues(String selectedValue) {
        List<String> DateTimeList = new ArrayList<String>();
        List<Schedule> scheduleList = DbHandler.GetSchedules();
        
        scheduleList.forEach((schedule) -> {         
            
            String startTime = schedule.StartDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"));
            String endTime = schedule.EndDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"));
            String scheduleDay = schedule.StartDateTime.toLocalDate().getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);

            if(scheduleDay.equals(selectedValue.substring(0,3))){
                
                DateTimeList.add(startTime + " - " + endTime + " " + schedule.ScheduleId); 
            }        
                        
        });        
        return DateTimeList;    
    }
    
    public static List<Schedule> getFreeSchedulesForDate(LocalDate date) {
        List<Schedule> resultList = new ArrayList<Schedule>();
        List<Schedule> scheduleList = DbHandler.GetSchedules();
        
        scheduleList.forEach((schedule) -> {         
            String startTime = schedule.StartDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"));
            String endTime = schedule.EndDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"));
            String scheduleDay = schedule.StartDateTime.toLocalDate().getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);

            if(schedule.StartDateTime.toLocalDate().equals(date)){
                resultList.add(schedule); 
            }                  
        });        
        return resultList;    
    }
    
    
    public static List<String> getScheduleDateListValues() {
           
        List<String> DateTimeList = new ArrayList<String>();
        List<Schedule> scheduleList = DbHandler.GetSchedules();
        List<String> DaysList = new ArrayList<String>();
        
        int setNumMonths = 2;       
        int numMonths;

        Calendar sDate = Calendar.getInstance();
        Date currentDate = new Date();
        
        DateFormat dayf = new SimpleDateFormat("E");
        DateFormat datef = new SimpleDateFormat("dd/MM/YYYY");
        
        sDate.setTime(currentDate);
        sDate.add(Calendar.DATE, 1);
        numMonths =sDate.get(Calendar.MONTH)+setNumMonths;
        
        scheduleList.forEach((schedule) -> {
            String scheduleDay = schedule.StartDateTime.toLocalDate().getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
            DaysList.add(scheduleDay);
        });
        
        Set<String> setDays = new HashSet<>(DaysList);
      
        while (numMonths > sDate.get(Calendar.MONTH)) {

            sDate.getTime();
            setDays.forEach((day) -> {                  
              
                if(dayf.format(sDate.getTime()).equals(day)){
                   DateTimeList.add(day+"  "+datef.format(sDate.getTime()));
                }
            });
            
          sDate.add(Calendar.DAY_OF_MONTH, 1);
        }    
        return DateTimeList;    
    }

    
   public String getCustomerPhoneById(String id) {
        
       String phone =null;
               
       List<Customer> customerList = DbHandler.GetCustomers();

        
        for(Customer customer:customerList){
          
            if(id.equals(String.valueOf(customer.CustomerId)))
            {
                phone=  customer.Phone;
            }            
        }        
        return phone;    
   }
   
  
   public String getCustomerNameByUsername(String userName) {
        
       String name = null;
       
       List<Customer> customerList = DbHandler.GetCustomers();
        
        for(Customer customer:customerList){
            
            if(userName.equals(customer.Username))
            {
                name =  customer.Name;
            }            
        }        
        return name;    
   }
   
   public static String getCustomerNameById(int id) {
        
       String name = null;
       
       List<Customer> customerList = DbHandler.GetCustomers();
        
        for(Customer customer:customerList){
            
            if(id ==customer.CustomerId)
            {
                name =  customer.Name;
            }            
        }        
        return name;    
   }
   
   public static Schedule getScheduleById(int id) {
	   
       List<Schedule> scheduleList = DbHandler.GetSchedules();
        
        for(Schedule schedule:scheduleList){
            
            if(id ==schedule.ScheduleId)
            {
                return schedule;
            }            
        }

        return null;
   }
   
   public static List<Schedule> getBookedSchedulesByCustomerId(int customerId)
   {
	   List<Booking> bookings = DbHandler.GetBookings();
	   List<Schedule> resultList = new ArrayList<Schedule>();
	   
	   for (Booking booking : bookings) {
		   if(booking.PersonForId == customerId)
		   {
			   resultList.add(DbHandler.GetSchedule(booking.ScheduleId));
		   }
	   }
	   
	   return resultList;
   }
   
   
   public boolean saveBookingMade(int pForId, int scheduleId){

       Booking newBooking = new Booking();
       
      if (!checkDoubleBooking(scheduleId)){  
           newBooking.ScheduleId = scheduleId;
           newBooking.PersonForId = pForId;
           newBooking.Status = BookingStatus.CONFIRMED;
           newBooking.BookingDate =  LocalDateTime.now();   
           DbHandler.SaveBooking(newBooking);
           return true;
       }
      return false;
   }
   
   
   boolean checkDoubleBooking(int Id)
   {        
       List<Booking> bookingList =  DbHandler.GetBookings();
       
       for(Booking booking:bookingList){
            if(Id == booking.ScheduleId){
                return true;
            }
        }
        return false;
   }
   
   
   Boolean checkCurrentUserIsCustomer(User user)
   {        
       List<Customer> customerList = DbHandler.GetCustomers();
        
        for(Customer customer:customerList){
            
            if(user.Username.equals(customer.Username))
            {
                return true;
            }            
        }        
        return false;     
   }
  
   
    public static List<Booking> getBookingSummaryList()
    {
        List <Booking> bookingSummary = new ArrayList();
        bookingSummary =  DbHandler.GetBookings();
        return bookingSummary;
    }
 
}