package controller;

import java.util.List;
import model.*;
import controller.DbHandler;

public class EmployeeController {

    public List<Employee> getEmployeeList()
    {
    	return DbHandler.GetEmployees();
    }
      
    public List createEmployeeList()
    {
        List employeeList = null;
        return employeeList;
    }
     
    public String createEmployeeDataString(List employeeList)
    {
        String employeeDataString = null;
        
        return employeeDataString;
    } 

}
