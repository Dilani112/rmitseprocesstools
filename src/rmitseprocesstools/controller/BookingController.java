package rmitseprocesstools.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import rmitseprocesstools.view.AddBookingView;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.swing.JOptionPane;
import rmitseprocesstools.DbHandler;
import rmitseprocesstools.model.Booking;
import rmitseprocesstools.model.Customer;
import rmitseprocesstools.model.Schedule;
import rmitseprocesstools.model.BookingStatus;
import rmitseprocesstools.view.BookingSummaryView;

public class BookingController {
    
    public String CurrentUser = "busines1";
    
    public void displayAddBookingView()
    {
        AddBookingView view = new AddBookingView();        
        view.setVisible(true);        
    }
    
    public void displayBookingSummaryView()
    {
        BookingSummaryView view = new BookingSummaryView();        
        view.setVisible(true);        
    }
    
  
    public static List<String> setCustomerNameList() {
        
        List<String> nameList = new ArrayList<String>();
        List<Customer> customerList = DbHandler.GetCustomers();
        BookingController controller = new BookingController();
        
        if(controller.checkCurrentUserIsCustomer(controller.CurrentUser))
        {
            String name = controller.getCustomerNameByUsername(controller.CurrentUser); 
            nameList.add(name);
        
        }else {
            customerList.forEach((customer) -> {
            nameList.add(customer.Name+" [ID - "+customer.CustomerId+" ]");
            });
        }
               
        return nameList;
    
    }
       
    public static List<String> setScheDuleTimeListValues(String selectedValue) {
           
        List<String> DateTimeList = new ArrayList<String>();
        List<Schedule> scheduleList = DbHandler.GetSchedules();
        
        scheduleList.forEach((schedule) -> {         
            
            String startTime = schedule.StartDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"));
            String endTime = schedule.EndDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"));
            String scheduleDay = schedule.StartDateTime.toLocalDate().getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);

            if(scheduleDay.equals(selectedValue.substring(0,3))){
                
                DateTimeList.add(startTime+" - "+endTime+" "+schedule.ScheduleId); 
            }        
                        
        });        
        return DateTimeList;    
    }
    
    
    public static List<String> setScheDuleDateListValues() {
           
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
        
       String name =null;
       
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
        
       String name =null;
       
       List<Customer> customerList = DbHandler.GetCustomers();
        
        for(Customer customer:customerList){
            
            if(id ==customer.CustomerId)
            {
                name =  customer.Name;
            }            
        }        
        return name;    
   }
   
   public static String getScheduleById(int id) {
        
       String scheduledata =null;
       
       List<Schedule> scheduleList = DbHandler.GetSchedules();
        
        for(Schedule schedule:scheduleList){
            
            if(id ==schedule.ScheduleId)
            {
                String startTime = schedule.StartDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"));
                String endTime = schedule.EndDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"));
                scheduledata =  startTime+" - "+endTime ;
            }            
        }        
        return scheduledata;    
   }
   
   
   public void saveBookingMade(int pForId,int scheduleId,String bDate){

       Booking newBooking = new Booking();
       
      if (!checkDoubleBooking(scheduleId,bDate)){  
           
           newBooking.ScheduleId = scheduleId;
           newBooking.PersonForId = pForId;
           newBooking.Status = BookingStatus.CONFIRMED;
           newBooking.BookingDate =  LocalDateTime.now();   
           DbHandler.SaveBooking(newBooking);        
       }else{
          JOptionPane.showMessageDialog(null,"This booking time is not available. Please try with a different time.","",JOptionPane.ERROR_MESSAGE);          
      }
   }
   
   
   boolean checkDoubleBooking(int Id, String date)
   {        
       List<Booking> bookingList =  DbHandler.GetBookings();
       DateTimeFormatter datef = DateTimeFormatter.ofPattern("E  dd/MM/YYYY");
       
       for(Booking booking:bookingList){
            String scheduleDay = booking.BookingDate.toLocalDate().format(datef);
            int sId = booking.ScheduleId;
            JOptionPane.showMessageDialog(null,sId+" "+scheduleDay,"",JOptionPane.ERROR_MESSAGE);          
            if(Id == sId && date.equals(scheduleDay)){
                JOptionPane.showMessageDialog(null,"true","",JOptionPane.ERROR_MESSAGE);
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"false","",JOptionPane.ERROR_MESSAGE);
                return false;
            }                 
        }
        return false;
   }
   
   
   Boolean checkCurrentUserIsCustomer(String currentUser)
   {        
       List<Customer> customerList = DbHandler.GetCustomers();
        
        for(Customer customer:customerList){
            
            if(currentUser.equals(customer.Username))
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