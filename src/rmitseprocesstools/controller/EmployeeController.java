package rmitseprocesstools.controller;

import rmitseprocesstools.view.AddEmployeeView;
import java.util.List;
import rmitseprocesstools.model.*;
import rmitseprocesstools.DbHandler;

public class EmployeeController {

    public void displayAddEmployeeView()
    {
        AddEmployeeView view = new AddEmployeeView();
        List<Employee> employeeList = DbHandler.GetEmployees();                
        view.setVisible(true);        
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
