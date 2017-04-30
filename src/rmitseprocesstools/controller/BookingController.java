package rmitseprocesstools.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import rmitseprocesstools.DbHandler;
import rmitseprocesstools.model.Customer;
import rmitseprocesstools.model.Business;
import rmitseprocesstools.model.Employee;
import rmitseprocesstools.model.Booking;
import rmitseprocesstools.model.Schedule;
import rmitseprocesstools.model.WorkTime;
import static rmitseprocesstools.controller.AuthController.currentUser;
import rmitseprocesstools.controller.AuthController;
import rmitseprocesstools.model.Activity;
import rmitseprocesstools.model.BookingStatus;

public class BookingController {
    
    public void populateBookingCustomerDetails(JComboBox jcbc,JTextField phone, JTextField address,boolean f){    
       
        List<Customer> list = DbHandler.GetCustomers();
        
        if(f){       
            for(Customer customer:list){                
                if(currentUser.Username.equals(customer.Username)){                
                    list.clear();
                    list.add(customer);
                    break;                        
                }
            }

            for(Customer customer:list){  

                jcbc.addItem(customer.Name+" [CusID]-"+customer.CustomerId);
            }
            
        }else{
                String text = jcbc.getSelectedItem().toString();
                String [] temp = text.split("\\-+") ;
                
                for(Customer customer:list){ 
                    if( Integer.toString(customer.CustomerId).equals(temp[1].trim())){
                        phone.setText(customer.Phone);
                        address.setText(customer.Address);  
                    }
                }
        }            
    }
    
    public void populateBookingBusinessDetails(JComboBox jcbb){  
        
        List<Business> list = DbHandler.GetBusinesses();
        
        for(Business business:list){                
                if(currentUser.Username.equals(business.Username)){                
                    list.clear();
                    list.add(business);
                    break;                        
                }
        }
        
        for(Business business:list){   

            jcbb.addItem(business.Name+" [ID]-"+business.BusinessId);
        }            

    }
    
   public void populateBookingEmployeeDetails(JComboBox jcbb,JComboBox jcbe){
       
        jcbe.removeAllItems();
        String text = jcbb.getSelectedItem().toString();
        String [] temp = text.split("\\-+") ;
        List<Employee> list = DbHandler.GetEmployeesByBusinessId(temp[1].trim());
        list.forEach((employee) -> {
            jcbe.addItem(employee.Name+" [ID]-"+employee.EmployeeId);

        });      
   }
   
    public void populateBookingActivityDetails(JComboBox jcbb,JComboBox jcba){
       
        jcba.removeAllItems();
        String text = jcbb.getSelectedItem().toString();
        String [] temp = text.split("\\-+") ;
        List<Activity> list = DbHandler.GetActivitiesByBusinessId(temp[1].trim());
        list.forEach((activity) -> {
            jcba.addItem(activity.Name+"("+activity.Duration+"Mins)"+" [ID]-"+activity.ActivityId);

        });      
   }
    
     
    public void populateBookingAvailableDates(JComboBox jcba) {
           
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
                   jcba.addItem(day+"  "+datef.format(sDate.getTime()));
                }
            });
            
          sDate.add(Calendar.DAY_OF_MONTH, 1);
        }    
    
    }

    
    public void populateBookingTimes(JList jsta, int businessId, int employeeId, String date) {
        
        Vector <String> DateTimeList = new Vector<String>();
        List<Schedule> scheduleList = DbHandler.GetSchedules();
        List<WorkTime> workList = EmployeeController.viewEmployeeAvailability(employeeId);
        DateTimeFormatter datef = DateTimeFormatter.ofPattern("E  dd/MM/YYYY");
        
        WorkTime availability = null;
        
        int startHour = -1, endHour = -1;
        
        for(WorkTime workTime:workList){
            if(workTime.EndDateTime.toLocalDate().format(datef).equals(date)){
                availability = workTime;
                startHour = availability.StartDateTime.getHour();
                endHour = availability.EndDateTime.getHour();
            }
        }
        

        
        for(Schedule schedule:scheduleList) {
            System.out.println(schedule.EndDateTime.getDayOfWeek().toString().substring(0, 3));
            if(schedule.BusinessId == businessId && availability != null && startHour != -1 && startHour <= schedule.StartDateTime.getHour() && endHour >= schedule.EndDateTime.getHour() && date.split("\\s+")[0].equalsIgnoreCase(schedule.EndDateTime.getDayOfWeek().toString().substring(0, 3))){
                String startTime = schedule.StartDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"));
                String endTime = schedule.EndDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"));
                String scheduleDay = schedule.StartDateTime.toLocalDate().getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
                    DateTimeList.add(startTime+" - "+endTime + " " + schedule.ScheduleId);
            }
        };   
        
        jsta.setListData(DateTimeList); 
        
    }
    
    
    public void populateCancellationBooking(JComboBox jcbb,JTextField date, JTextField time, boolean f) {
        
        List<Customer> list = new ArrayList();
        List<Booking> listb = new ArrayList();
        List<Schedule> lists = new ArrayList();
        
        list = DbHandler.GetCustomers();
        listb = DbHandler.GetBookings();
        lists = DbHandler.GetSchedules();
        
        
        if(f){
            for(Customer customer:list){
                if(currentUser.Username.equals(customer.Username)){
                    for(Booking booking:listb){                 
                        if(booking.PersonForId == customer.CustomerId){
                            if(booking.Status.equals(BookingStatus.CONFIRMED)){                            
                                jcbb.addItem(booking.BookingId);
                            }
                           
                        }
                    }                
                }
            }
        }else{
            
            String text = jcbb.getSelectedItem().toString();
            for(Booking b:listb) {
                if( Integer.toString(b.BookingId).equals(text)){
                    date.setText(b.BookingDate.toLocalDate().format(DateTimeFormatter.ISO_DATE));
                    
                    for(Schedule s:lists){
                       if(s.ScheduleId==b.ScheduleId){
                           time.setText(s.StartDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"))
                                   +" - "+s.EndDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a")));
                       }                        
                    }
                    
                }               

            }
        }     
        
    }
    

    public boolean cancelBooking(String bookingId){

        List <Booking> list = new ArrayList();
        list = DbHandler.GetBookings();
        
        for(Booking booking:list){
            if( Integer.toString(booking.BookingId).equals(bookingId)){
               booking.Status = BookingStatus.CANCELLED;
               System.out.println(booking.Status);
               DbHandler.SaveBooking(booking);
               JOptionPane.showMessageDialog(null,"Booking has been cancelled.","",JOptionPane.ERROR_MESSAGE);
               return true;
            }               
        }
        return false;         
   }
    
    
    public void populateTrackBooking(JComboBox jcbb,JTextField date, JTextField time, JTextField status, boolean f){
        
        List<Customer> list = new ArrayList();
        List<Booking> listb = new ArrayList();
        List<Schedule> lists = new ArrayList();
        
        list = DbHandler.GetCustomers();
        listb = DbHandler.GetBookings();
        lists = DbHandler.GetSchedules();
        
        
        if(f){
            for(Customer customer:list){
                if(currentUser.Username.equals(customer.Username)){                
                    for(Booking booking:listb){                 
                        if(booking.PersonForId == customer.CustomerId){
                                                        
                            jcbb.addItem(booking.BookingId);
                        }                        
                    }                
                }
            }
        }else{
            
            String text = jcbb.getSelectedItem().toString();
            for(Booking b:listb) {
                if( Integer.toString(b.BookingId).equals(text)){
                    date.setText(b.BookingDate.toLocalDate().format(DateTimeFormatter.ISO_DATE));
                    status.setText(b.Status.toString());
                    for(Schedule s:lists){
                       if(s.ScheduleId==b.ScheduleId){
                           time.setText(s.StartDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"))
                                   +" - "+s.EndDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a")));
                       }                        
                    }
                    
                }               

            }
        }     
    
        
    }
    
    
    public static List<Booking> getBookingSummaryList(JLabel lbl)
    {
        List <Booking> bookingSummary = new ArrayList();
        List <Booking> listb = new ArrayList();
        List <Customer> listc = new ArrayList();
        int custId=0;
        
        
        listb = DbHandler.GetBookings();
        listc = DbHandler.GetCustomers();
         
        for(Customer customer:listc){
            if(customer.Username.equals(AuthController.currentUser.Username)){
                custId=customer.CustomerId;
                bookingSummary = DbHandler.GetBookingsByPersonId( Integer.toString(custId));
                lbl.setText("Booking History");
                return bookingSummary;
            }
        }
        lbl.setText("Booking Summary");
        return listb;
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
    
    public boolean btnCancel(){
       
       List<Customer> list = DbHandler.GetCustomers();
       
       for (Customer c:list){
           if(currentUser.Username.equals(c.Username)){
               return true;
           }
       }
       return false;       
    } 
    
    
    public void saveBookingMade(int employeeId,int activityId,int pForId,int scheduleId,String bDate){

       Booking newBooking = new Booking();
       
        // Until the Activities are implemented
        activityId = 1;
        DateTimeFormatter datef = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String[] temp = bDate.split("\\s+");
        try{
            LocalDate bDateTime = LocalDate.parse(temp[temp.length-1], datef);
            LocalDateTime finalDate = LocalDateTime.of(bDateTime, LocalTime.MIN);
            if (!checkDoubleBooking(scheduleId,bDate)){  
           
                newBooking.ScheduleId = scheduleId;
                newBooking.PersonForId = pForId;
                newBooking.EmployeeId= employeeId;
                newBooking.ActivityId = activityId;
                newBooking.Status = BookingStatus.CONFIRMED;
                newBooking.BookingDate =  finalDate;
                System.out.println(newBooking.Status + " " + newBooking.BookingDate);
                DbHandler.SaveBooking(newBooking);
                JOptionPane.showMessageDialog(null,"Booking Successful.","",JOptionPane.ERROR_MESSAGE);          
            }else{
                JOptionPane.showMessageDialog(null,"This booking time is not available. Please try with a different time.","",JOptionPane.ERROR_MESSAGE);          
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    boolean checkDoubleBooking(int Id, String date)
    {        
       List<Booking> bookingList =  DbHandler.GetBookings();
       DateTimeFormatter datef = DateTimeFormatter.ofPattern("E  dd/MM/YYYY");
       
       for(Booking booking:bookingList){
            String scheduleDay = booking.BookingDate.toLocalDate().format(datef);
            int sId = booking.ScheduleId;
//            JOptionPane.showMessageDialog(null,sId+" "+scheduleDay,"",JOptionPane.ERROR_MESSAGE);          
            if(Id == sId && date.equals(scheduleDay)){
//                JOptionPane.showMessageDialog(null,"true","",JOptionPane.ERROR_MESSAGE);
                return true;
            }else{
//                JOptionPane.showMessageDialog(null,"false","",JOptionPane.ERROR_MESSAGE);
                return false;
            }                 
        }
        return false;
   }
 
}