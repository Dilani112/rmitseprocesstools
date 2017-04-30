package rmitseprocesstools.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import rmitseprocesstools.model.*;
import rmitseprocesstools.DbHandler;
import rmitseprocesstools.Utility;
import static rmitseprocesstools.controller.AuthController.currentUser;

public class EmployeeController {
    
    public boolean addEmployee(String name, String address,String phone) 
    {
        Employee newEmployee = new Employee();
               
        Utility utility = new Utility();
               
        if(utility.validateName(name) && utility.validatePhone(phone) && utility.validateAddress(address)){            
            newEmployee.Phone = phone;
            newEmployee.Name = name;
            newEmployee.Address = address;         
            DbHandler.SaveEmployee(newEmployee);
            JOptionPane.showMessageDialog(null,"Employee data successfuly saved.","",JOptionPane.INFORMATION_MESSAGE); 
            return true;
        }else{
            JOptionPane.showMessageDialog(null,"Saving employee data failed.","",JOptionPane.ERROR_MESSAGE);
        }
        return false;
   }

   public boolean addEmployeeWorkTime(int nemployeeID,String nDate,String nShrs, String nFhrs,
            String nSmins, String nFmins){

        AuthController controller = new  AuthController();
        Business business =new Business(); 
        WorkTime newWorkTime = new WorkTime();
        
        business = controller.queryBusiness(currentUser.Username);
       
        String startDate = nDate+" "+nShrs+":"+nSmins ;
        String finishDate = nDate+" "+nFhrs+":"+nFmins ;      
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        newWorkTime.EmployeeId = nemployeeID;
        newWorkTime.BusinessId = business.BusinessId;
        newWorkTime.StartDateTime = LocalDateTime.parse(startDate, format);
        newWorkTime.EndDateTime =  LocalDateTime.parse(finishDate, format);   
        DbHandler.SaveWorkTime(newWorkTime);        
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
                employeeAvailabilityList.add(workTime) ;
            }            
        }   
                
        return employeeAvailabilityList;
    }
    

    
   public List<String> constructCmbEmployeeList(){
   
        List<String> employeeNameList = new ArrayList();
        List<Employee> employeeList = DbHandler.GetEmployees();
        
        employeeList.forEach((employee) -> {
            employeeNameList.add(employee.Name+" [ID - "+employee.EmployeeId+" ]");
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
    
    
    public List<String> constructCmbWorkingDatesList(){
   
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