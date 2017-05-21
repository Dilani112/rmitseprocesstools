package rmitseprocesstools.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import rmitseprocesstools.InfoLogger;
import rmitseprocesstools.model.*;
import rmitseprocesstools.DbHandler;
import rmitseprocesstools.Utility;
import static rmitseprocesstools.controller.AuthController.currentUser;
import rmitseprocesstools.model.Employee;

public class EmployeeController {
    private final static Logger LOGGER = Logger.getLogger(InfoLogger.class.getName());

    public boolean addEmployee(String name, String address,String phone) 
    {
        LOGGER.entering(getClass().getName(), "addEmployee");

        Employee newEmployee = new Employee();
               
        Utility utility = new Utility();
        
        Business current = (Business) AuthController.currentUser;
        
        if(utility.validateName(name) && utility.validatePhone(phone) && utility.validateAddress(address)){            
            newEmployee.Phone = phone;
            newEmployee.Name = name;
            newEmployee.Address = address;
            newEmployee.BusinessId = current.BusinessId;
            DbHandler.SaveEmployee(newEmployee);
            LOGGER.info("New employee " + newEmployee.EmployeeId + " was successfully updated.");
            JOptionPane.showMessageDialog(null,"Employee data successfuly saved.","",JOptionPane.INFORMATION_MESSAGE);
            return true;
        }else{
            LOGGER.warning("New employee data was invalid.");
            JOptionPane.showMessageDialog(null,"Saving employee data failed.","",JOptionPane.ERROR_MESSAGE);
        }
        return false;
   }

   public boolean addEmployeeWorkTime(int nemployeeID,String nShrs, String nFhrs,
            String nSmins, String nFmins, boolean monday, boolean tuesday, boolean wednesday,
            boolean thursday, boolean friday, boolean saturday, boolean sunday){
        LOGGER.entering(getClass().getName(), "addEmployeeWorkTime");

        List<WorkTime> workTimes = DbHandler.GetWorkTime();

        AuthController controller = new  AuthController();
        Business business = (Business) AuthController.currentUser; 
        WorkTime newWorkTime = new WorkTime();
       
        String startDate = nShrs+":"+nSmins ;
        String finishDate = nFhrs+":"+nFmins ;
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime startTime = LocalTime.parse(startDate, format);
        LocalTime endTime = LocalTime.parse(finishDate, format);
        
        newWorkTime.EmployeeId = nemployeeID;
        newWorkTime.BusinessId = business.BusinessId;
        newWorkTime.StartDateTime = LocalDateTime.of(LocalDate.now(), startTime);
        newWorkTime.EndDateTime =  LocalDateTime.of(LocalDate.now(), endTime);
        if(newWorkTime.EndDateTime.compareTo(newWorkTime.StartDateTime) <= 0){
            JOptionPane.showMessageDialog(null, "Invalid Start Time and End Time, The End Time can't be the same or earlier than the start time", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        newWorkTime.Monday = monday;
        newWorkTime.Tuesday = tuesday;
        newWorkTime.Wednesday = wednesday;
        newWorkTime.Thursday = thursday;
        newWorkTime.Friday = friday;
        newWorkTime.Saturday = saturday;
        newWorkTime.Sunday = sunday;

        workTimes.forEach((c) -> {
            if(c.BusinessId == newWorkTime.BusinessId && c.EmployeeId == newWorkTime.EmployeeId)
                newWorkTime.WorkTimeId = c.WorkTimeId;
        });

        DbHandler.SaveWorkTime(newWorkTime);
        LOGGER.info("WorkTime " + newWorkTime.WorkTimeId + " was successfully saved.");
        JOptionPane.showMessageDialog(null,"Employee time has been saved.","",JOptionPane.ERROR_MESSAGE);
        
        return true;
   } 
  
   public static List<WorkTime> viewEmployeeAvailability(int id){
       
        List <WorkTime> allEmployeeWorkTimeList = new ArrayList();
        List <WorkTime> employeeAvailabilityList = new ArrayList();
        allEmployeeWorkTimeList =  DbHandler.GetWorkTime();
        
        for(WorkTime workTime:allEmployeeWorkTimeList){
            
            if(id == workTime.EmployeeId)
            {
                employeeAvailabilityList.add(workTime);
            }            
        }   
                
        return employeeAvailabilityList;
    }
    
   public List<String> constructCmbEmployeeList(){
   
        List<String> employeeNameList = new ArrayList();
        List<Employee> employeeList = DbHandler.GetEmployees();
        
        Business current = (Business) AuthController.currentUser;
        
        employeeList.forEach((employee) -> {
            if(employee.BusinessId == current.BusinessId){
                employeeNameList.add(employee.Name+" [ID - "+employee.EmployeeId+" ]");
            }
        });
          
        return employeeNameList;
   }
    
    
    public List<String> constructCmbHoursList(){
   
        List<String> hrsList = new ArrayList();
        int numHrs = 24;
         
        for(int i=0;i<numHrs;i++){
            if(i<10){
                hrsList.add("0"+String.valueOf(i));
            }else{
                 hrsList.add(String.valueOf(i));
            }
            
        }
          
        return hrsList;
   }
    
    
    public List<String> constructCmbMinsList(){
   
        List<String> minsList = new ArrayList();
        int numMins = 60;
         
        for(int i=0;i<numMins;i++){
            if(i<10){
                minsList.add("0"+String.valueOf(i));
            }else{
                 minsList.add(String.valueOf(i));
            }                
        }
          
        return minsList;
   }
           
    public  List<String> constructCmbEmployeeListbyBusinessId()
    {
        AuthController controller = new  AuthController();
        Business business = new Business();
        business = controller.queryBusiness(currentUser.Username); 
        List <String> employeeNameList = new ArrayList();  
        
        List <Employee> employeeList = DbHandler.GetEmployeesByBusinessId(Integer.toString(business.BusinessId));
        
        for(Employee employee:employeeList){

                employeeNameList.add(employee.Name+" [ID - "+employee.EmployeeId+" ]"); 
                
        }   
                
        return employeeNameList;
    }
}