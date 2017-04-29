package rmitseprocesstools.controller;

import java.util.List;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import rmitseprocesstools.DbHandler;
import rmitseprocesstools.model.Customer;
import rmitseprocesstools.model.Business;
import rmitseprocesstools.model.Employee;
import rmitseprocesstools.model.Booking;
import rmitseprocesstools.model.Schedule;
import static rmitseprocesstools.controller.AuthController.currentUser;

public class BookingController {
    
    public static List<Customer> setBookingCustomerDetails(String user) {
    
        List<Customer> c =null;
        List<Customer> customerList = DbHandler.GetCustomers();
        
        c=customerList;
        
        if(user==null)
            user = currentUser.Username;
        
        for(Customer customer:customerList){
            
            if(user.equals(customer.Username)){                
                c.clear();
                c.add(customer); 
                break;                        
            }                
        }   
        return c;   
    }
    
    
    public static List<Business> setBookingBusinessrDetails(String user) {
    
        List<Business> b =null;
        List<Business> businessList = DbHandler.GetBusinesses();
        
        b=businessList;
        
        if(user==null)
            user = currentUser.Username;
        
        for(Business business:businessList){
            
            if(user.equals(business.Username)){                
                b.clear();
                b.add(business); 
                break;                        
            }                
        }   
        return b;   
    }
    
    
    public static List<Employee> setBookingEmployeesByBusiness(String id) {
    
        List<Employee> e =null;
        List<Employee> employeeList = DbHandler.GetEmployees();
        List<Business> businessList = DbHandler.GetBusinesses();
        int bId =0;
        
        if(id==null){
            
            for(Business business:businessList){            
                if(currentUser.Username.equals(business.Username)){                
                    bId = business.BusinessId;                        
                }                
            }
        }else{
            bId = Integer.parseInt(id);
        }
//prob here
        for(Employee employee:employeeList){

            if(bId == employee.BusinessId){                
                JOptionPane.showMessageDialog(null,employee.BusinessId,"",JOptionPane.ERROR_MESSAGE);
                e.add(employee);
            }                
        }   
          
        return e;   
    }
       
    public static List<Booking> getBookingSummaryList()
    {
        List <Booking> bookingSummary = new ArrayList();
        bookingSummary =  DbHandler.GetBookings();
        return bookingSummary;
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
    
    
    
    
    
    
    
    
    
    
    
    
    
 /*   
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
    
    public static List<String> setCustomerNameList() {
        
        List<String> nameList = new ArrayList<String>();
        List<Customer> customerList = DbHandler.GetCustomers();
        BookingController controller = new BookingController();
        //controller.CurrentUser.Username
        if(controller.checkCurrentUserIsCustomer("cust@test.com"))
        {
            String name = controller.getCustomerNameByUsername("cust@test.com"); 
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
   
   
   
  
   
    
*/ 
}