package rmitseprocesstools.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import rmitseprocesstools.view.AddEmployeeView;
import rmitseprocesstools.view.AddWorkTimeView;
import rmitseprocesstools.view.EmployeeAvailabilityView;
import java.util.List;
import javax.swing.JOptionPane;
import rmitseprocesstools.model.*;
import rmitseprocesstools.DbHandler;
import rmitseprocesstools.Utility;

public class EmployeeController {

    public User CurrentUser = null;
        
    public void displayAddEmployeeView()
    {
        AddEmployeeView view = new AddEmployeeView();               
        view.setVisible(true);        
    }
    
    public void displayAddWorkTimeView()
    {
        AddWorkTimeView view = new AddWorkTimeView();               
        view.setVisible(true);        
    }
     
    public void displayEmployeeAvailabilityView()
    {
        EmployeeAvailabilityView view = new EmployeeAvailabilityView();               
        view.setVisible(true);        
    }
    
    public boolean saveEmployeeMade(String name, String address,String phone) 
    {
        Employee newEmployee = new Employee();
        BussinessOwnerController view = new BussinessOwnerController();
               
        Utility utility = new Utility();
               
        if(utility.validateName(name) && utility.validatePhone(phone)){            
            newEmployee.Phone = phone;
            newEmployee.Name = name;
            newEmployee.Address = address;         
            DbHandler.SaveEmployee(newEmployee);
            JOptionPane.showMessageDialog(null,"Employee data successfuly saved.","",JOptionPane.INFORMATION_MESSAGE); 
            view.displayBussinessOwnerOperationsView();
            return true;
        }
        return false;
   }

    public List<String> getEmployeeList(){
   
        List<String> employeeNameList = new ArrayList();
        List<Employee> employeeList = DbHandler.GetEmployees();
        
        employeeList.forEach((employee) -> {
            employeeNameList.add(employee.Name+" [ID - "+employee.EmployeeId+" ]");
        });        
          
        return employeeNameList;
   }
    
    
    public List<String> getHoursList(){
   
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
    
    
    public List<String> getMinsList(){
   
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
    
    
    public List<String> getWorkingDatesList(){
   
        List<String> daysList = new ArrayList<String>();
        
        int setNumMonths = 1;       

        Calendar sDate = Calendar.getInstance();
        Calendar fDate = Calendar.getInstance();
        
        Date currentDate = new Date();       
        
        DateFormat datef = new SimpleDateFormat("dd/MM/YYYY");
        
        sDate.setTime(currentDate);
        sDate.add(Calendar.DATE, 1);
        fDate.setTime(currentDate);
        fDate.roll(Calendar.MONTH, setNumMonths);        
        
         while (sDate.getTime().before(fDate.getTime()))
        {
            daysList.add(datef.format(sDate.getTime()));
            sDate.add(Calendar.DATE, 1);
        }
        return daysList;
   }
    
    
    public void saveEmployeeWorkTimeMade(int nemployeeID,String nDate,String nShrs, String nFhrs,
            String nSmins, String nFmins){

        WorkTime newWorkTime = new WorkTime();
               
        String startDate = nDate+" "+nShrs+":"+nSmins ;
        String finishDate = nDate+" "+nFhrs+":"+nFmins ;      
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        newWorkTime.EmployeeId = nemployeeID;
        newWorkTime.BusinessId = getBusinessIdByUserName(CurrentUser.Username);
        newWorkTime.StartDateTime = LocalDateTime.parse(startDate, format);
        newWorkTime.EndDateTime =  LocalDateTime.parse(finishDate, format);   
        DbHandler.SaveWorkTime(newWorkTime);        
        JOptionPane.showMessageDialog(null,"Employee time has been saved.","",JOptionPane.ERROR_MESSAGE);
             
   }
    
    public int getBusinessIdByUserName(String currentUser)
    {
        int businessId = 0;
        
        List<Business> businessList = DbHandler.GetBusinesses();
        
       for(Business business:businessList){
            
            if(currentUser.equals(business.Username))
            {
                businessId =  business.BusinessId;  
            }            
        }  
        return businessId;
    }
    
    
    public static List<WorkTime> getEmployeeAvailabilityListbyEmployeeId(int id)
    {
        List <WorkTime> allEmployeeWorkTimeList = new ArrayList();
        List <WorkTime> employeeAvailabilityList = new ArrayList();
        allEmployeeWorkTimeList =  DbHandler.GetWorkTime();
        
        for(WorkTime workTime:allEmployeeWorkTimeList){
            
            if(id == workTime.EmployeeId)
            {
                employeeAvailabilityList.add(workTime) ;
            }            
        }   
                
        return employeeAvailabilityList;
    }
    
    public  List<String> getEmployeeListbyBusinessId()
    {
        List <Employee> allEmployeeList = new ArrayList();
        List <String> employeeList = new ArrayList();
        allEmployeeList =  DbHandler.GetEmployees();
        
        for(Employee employee:allEmployeeList){
            
            if(getBusinessIdByUserName(CurrentUser.Username) == employee.BusinessId)
            {
                employeeList.add(employee.Name+" [ID - "+employee.EmployeeId+" ]") ;
            }            
        }   
                
        return employeeList;
    }
    
    public static String getEmployeeNameById(int id)
    {
        String name="";
        List<Employee> employeeList = DbHandler.GetEmployees();
        
        for(Employee employee:employeeList){
            
            if(id == employee.EmployeeId)
            {
                name = employee.Name ;
            }            
        }            
        return name;
    }
    
}