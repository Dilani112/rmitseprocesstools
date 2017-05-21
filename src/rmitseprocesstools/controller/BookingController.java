package rmitseprocesstools.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
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
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import rmitseprocesstools.DbHandler;
import rmitseprocesstools.InfoLogger;
import rmitseprocesstools.model.*;

import static rmitseprocesstools.controller.AuthController.currentUser;
import rmitseprocesstools.controller.AuthController;

public class BookingController {
    private final static Logger LOGGER = Logger.getLogger(InfoLogger.class.getName());

    public List<String> GetCustomerDisplayList()
    {
        List<Customer> customerList = DbHandler.GetCustomers();
        List<String> returnList = new ArrayList<String>();
        for(Customer customer:customerList){
            if(currentUser.Username.equals(customer.Username)){
                customerList.clear();
                customerList.add(customer);
                break;
            }
        }
        for(Customer customer:customerList){
            returnList.add(customer.Name+" [CusID]-"+customer.CustomerId);
        }

        return returnList;
    }

    public List<String> GetBusinessDisplayList() {
        List<Business> businessList = DbHandler.GetBusinesses();
        List<String> returnList = new ArrayList<String>();
        for (Business business : businessList) {
            if (currentUser.Username.equals(business.Username)) {
                businessList.clear();
                businessList.add(business);
                break;
            }
        }
        for (Business business : businessList) {
            returnList.add(business.Name + " [ID]-" + business.BusinessId);
        }

        return returnList;
    }

    public Customer GetSelectedCustomerDetails(String selectedValue)
    {
        List<Customer> customerList = DbHandler.GetCustomers();
        String [] temp = selectedValue.split("\\-+");
        Customer returnValue = new Customer();

        for(Customer customer:customerList){
            if( Integer.toString(customer.CustomerId).equals(temp[1].trim())){
                return customer;
            }
        }

        return null;
    }

    public List<String> GetEmployeeDisplayList(String selectedBusiness) {
        List<String> returnList = new ArrayList<String>();
        String[] temp = selectedBusiness.split("\\-+");
        List<Employee> list = DbHandler.GetEmployeesByBusinessId(temp[1].trim());
        list.forEach((employee) -> {
            returnList.add(employee.Name + " [ID]-" + employee.EmployeeId);
        });

        return returnList;
    }

    public List<String> GetActivityDisplayList(String selectedBusiness)
    {
        List<String> returnList = new ArrayList<String>();
        String [] temp = selectedBusiness.split("\\-+") ;
        List<Activity> list = DbHandler.GetActivitiesByBusinessId(temp[1].trim());
        list.forEach((activity) -> {
            returnList.add(activity.Name+"("+activity.Duration+"Mins)"+" [ID]-"+activity.ActivityId);
        });

        return returnList;
    }
    
     
    public List<String> GetBookingAvailableDates() {
        List<String> resultList = new ArrayList<String>();
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

        for (LocalDate date = LocalDate.now(); date.isBefore(LocalDate.now().plusMonths(2)); date = date.plusDays(1))
        {
            DaysList.add(date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
        }

        Set<String> setDays = new HashSet<>(DaysList);
      
        while (numMonths > sDate.get(Calendar.MONTH)) {

            sDate.getTime();
            setDays.forEach((day) -> {                  
              
                if(dayf.format(sDate.getTime()).equals(day)){
                   resultList.add(day+"  "+datef.format(sDate.getTime()));
                }
            });
            
          sDate.add(Calendar.DAY_OF_MONTH, 1);
        }    

        return resultList;
    }

    public List<String> GetBookingTimes(int businessId, int employeeId, String date, int activityId)
    {
        List<String> returnList = new ArrayList<String>();
        List<Booking> bookingList = DbHandler.GetBookings();
        List<WorkTime> workList = EmployeeController.viewEmployeeAvailability(employeeId);
        DateTimeFormatter datef = DateTimeFormatter.ofPattern("E  dd/MM/YYYY");

        String a = date.substring(date.indexOf(" ")+2);
        LocalDate dateTime = LocalDate.parse(a, DateTimeFormatter.ofPattern("dd/MM/uuuu"));

        Activity activity = null;
        for (Activity act : DbHandler.GetActivities()) {
            if (act.ActivityId == activityId)
                activity = act;
        }
        int activityTime = activity.Duration;

        WorkTime temp = null;
        WorkTime availability = null;

        LocalTime startHour = null, endHour = null;

        for(WorkTime workTime:workList){
            if(workTime.BusinessId == businessId && workTime.EmployeeId == employeeId){
                temp = workTime;
            }
        }

        if((dateTime.getDayOfWeek() == DayOfWeek.MONDAY && temp.Monday ||
                dateTime.getDayOfWeek() == DayOfWeek.TUESDAY && temp.Tuesday ||
                dateTime.getDayOfWeek() == DayOfWeek.WEDNESDAY && temp.Wednesday ||
                dateTime.getDayOfWeek() == DayOfWeek.THURSDAY && temp.Thursday ||
                dateTime.getDayOfWeek() == DayOfWeek.FRIDAY && temp.Friday ||
                dateTime.getDayOfWeek() == DayOfWeek.SATURDAY && temp.Saturday ||
                dateTime.getDayOfWeek() == DayOfWeek.SUNDAY && temp.Sunday) && temp != null)
        {
            LocalTime startTime = temp.StartDateTime.toLocalTime();
            LocalTime endTime = temp.EndDateTime.toLocalTime();
            for (LocalTime time = startTime; time.plusMinutes(activityTime).isBefore(endTime.plusMinutes(1)); time = time.plusMinutes(activityTime))
            {
                LocalTime slotStartTime = time;
                LocalTime slotEndTime = time.plusMinutes(activityTime);
                boolean isAvailable = true;
                for(Booking booking:bookingList) {
                    LocalTime scheduleStartTime = booking.getStartDateTime().toLocalTime();
                    LocalTime scheduleEndTime = booking.getEndDateTime().toLocalTime();

                    if(booking.getEmployeeId() == employeeId
                            && booking.getBookingDate().toLocalDate().isEqual(dateTime)
                            && (((scheduleStartTime.isAfter(slotStartTime) && scheduleStartTime.isBefore(slotEndTime)) || scheduleStartTime.equals(slotStartTime))
                            ||
                            ((scheduleEndTime.isAfter(slotStartTime) && scheduleEndTime.isBefore(slotEndTime)) || scheduleEndTime.equals(slotEndTime))))
                    {
                        isAvailable = false;
                    }
                }

                if(isAvailable)
                    returnList.add(time.format(DateTimeFormatter.ofPattern("h:mm a"))+" - "+time.plusMinutes(activityTime).format(DateTimeFormatter.ofPattern("h:mm a")));
            }
        }

        return returnList;
        //jsta.setListData(DateTimeList);
    }

    public void populateCancellationBooking(JComboBox jcbb,JTextField date, JTextField time, boolean f) {

        List<Customer> list = new ArrayList();
        List<Booking> listb = new ArrayList();

        list = DbHandler.GetCustomers();
        listb = DbHandler.GetBookings();


        if(f){
            for(Customer customer:list){
                if(currentUser.Username.equals(customer.Username)){
                    for(Booking booking:listb){                 
                        if(booking.getPersonForId() == customer.CustomerId){
                            if(booking.getStatus().equals(BookingStatus.CONFIRMED)){
                                jcbb.addItem(booking.getBookingId());
                            }
                           
                        }
                    }                
                }
            }
        }else{
            
            String text = jcbb.getSelectedItem().toString();
            for(Booking b:listb) {
                if( Integer.toString(b.getBookingId()).equals(text)){
                    date.setText(b.getBookingDate().toLocalDate().format(DateTimeFormatter.ISO_DATE));
                           time.setText(b.getStartDateTime().toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"))
                                   +" - "+b.getEndDateTime().toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a")));
                }               

            }
        }     
        
    }
    

    public boolean cancelBooking(String bookingId){
        LOGGER.entering(getClass().getName(), "cancelBooking");

        List <Booking> list = new ArrayList();
        list = DbHandler.GetBookings();
        
        for(Booking booking:list){
            if( Integer.toString(booking.getBookingId()).equals(bookingId)){
               booking.setStatus(BookingStatus.CANCELLED);
               System.out.println(booking.getStatus());
               DbHandler.SaveBooking(booking);
               LOGGER.info("Booking " + bookingId + " has been cancelled");
               JOptionPane.showMessageDialog(null,"Booking has been cancelled.","",JOptionPane.ERROR_MESSAGE);
               return true;
            }               
        }

        LOGGER.info("Booking could not be found with ID " + bookingId);
        return false;
   }
    
    
    public void populateTrackBooking(JComboBox jcbb,JTextField date, JTextField time, JTextField status, boolean f){
        
        List<Customer> list = new ArrayList();
        List<Booking> listb = new ArrayList();
        
        list = DbHandler.GetCustomers();
        listb = DbHandler.GetBookings();
        
        
        if(f){
            for(Customer customer:list){
                if(currentUser.Username.equals(customer.Username)){                
                    for(Booking booking:listb){                 
                        if(booking.getPersonForId() == customer.CustomerId){
                                                        
                            jcbb.addItem(booking.getBookingId());
                        }                        
                    }                
                }
            }
        }else{
            
            String text = jcbb.getSelectedItem().toString();
            for(Booking b:listb) {
                if( Integer.toString(b.getBookingId()).equals(text)){
                    date.setText(b.getBookingDate().toLocalDate().format(DateTimeFormatter.ISO_DATE));
                    status.setText(b.getStatus().toString());
                           time.setText(b.getStartDateTime().toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a"))
                                   +" - "+b.getEndDateTime().toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a")));
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

    public static String GetBookingActivityName(int bookingId)
    {
        Booking booking = null;
        for (Booking b: DbHandler.GetBookings()) {
            if(b.getBookingId() == bookingId)
                booking = b;
        }

        if(booking != null) {
            Activity activity = null;
            for (Activity a : DbHandler.GetActivities()) {
                if (a.ActivityId == booking.getActivityId())
                    activity = a;
            }
            if(activity != null)
                return activity.Name;
        }

        return "";
    }
    
    public void saveBookingMade(int employeeId,int businessId,int activityId,int pForId,String startTimeString,String endTimeString,String bDate){
        LOGGER.entering(getClass().getName(), "saveBookingMade");
       
        List<Activity> activities = DbHandler.GetActivities();
        LocalTime startTime = LocalTime.parse(startTimeString, DateTimeFormatter.ofPattern("h:mm a"));
        LocalTime endTime = LocalTime.parse(endTimeString, DateTimeFormatter.ofPattern("h:mm a"));
        Activity curActivity = null;
        
        for(Activity activity:activities){
            if(activity.ActivityId == activityId) curActivity = activity;
        }

        boolean bookingMade = false;
        
        boolean doubleBooked = checkDoubleBooking(bDate, startTime, endTime, employeeId);

        System.out.println(doubleBooked);

        DateTimeFormatter datef = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String[] temp = bDate.split("\\s+");

            try{
                LocalDate bDateTime = LocalDate.parse(temp[temp.length-1], datef);
                LocalDateTime finalDate = LocalDateTime.of(bDateTime, LocalTime.MIN);
                
                if (!doubleBooked){
                    Booking newBooking = new Booking();
                    newBooking.setPersonForId(pForId);
                    newBooking.setEmployeeId(employeeId);
                    newBooking.setActivityId(activityId);
                    newBooking.setStatus(BookingStatus.CONFIRMED);
                    newBooking.setBookingDate(finalDate);
                    newBooking.setStartDateTime(LocalDateTime.of(bDateTime, startTime));
                    newBooking.setEndDateTime(LocalDateTime.of(bDateTime, endTime));
                    System.out.println(newBooking.getStatus() + " " + newBooking.getBookingDate());
                    DbHandler.SaveBooking(newBooking);
                    bookingMade = true;          
                }else{
                    LOGGER.warning("Unavailable booking time selected");
                    bookingMade = false;
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        if(doubleBooked) JOptionPane.showMessageDialog(null,"This booking time is not available. Please try with a different time.","",JOptionPane.ERROR_MESSAGE);          
        if(bookingMade)JOptionPane.showMessageDialog(null,"Booking Successful.","",JOptionPane.ERROR_MESSAGE);
    }
    
    
    boolean checkDoubleBooking(String date, LocalTime startTime, LocalTime endTime, int employeeId)
    {        
       List<Booking> bookingList =  DbHandler.GetBookings();
       DateTimeFormatter datef = DateTimeFormatter.ofPattern("E  dd/MM/YYYY");
       
       for(Booking booking:bookingList){
           if(booking.getEmployeeId() == employeeId) {
               String scheduleDay = booking.getBookingDate().toLocalDate().format(datef);

//            JOptionPane.showMessageDialog(null,sId+" "+scheduleDay,"",JOptionPane.ERROR_MESSAGE);          
                   if (date.equals(scheduleDay) && ((startTime.isAfter(booking.getStartDateTime().toLocalTime()) && startTime.isBefore(booking.getEndDateTime().toLocalTime())) ||
                           (endTime.isAfter(booking.getStartDateTime().toLocalTime()) && endTime.isBefore(booking.getEndDateTime().toLocalTime())))) {
//                JOptionPane.showMessageDialog(null,"true","",JOptionPane.ERROR_MESSAGE);
                       return true;
                   }
           }
        }
        return false;
   }
 
}