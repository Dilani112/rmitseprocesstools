package rmitseprocesstools.unit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.BeforeClass;
import rmitseprocesstools.DbHandler;
import rmitseprocesstools.controller.AuthController;
import rmitseprocesstools.controller.EmployeeController;
import rmitseprocesstools.model.Business;
import rmitseprocesstools.model.Employee;
/**
 *
 * @author Thejana
 */
public class EmployeeTests {
    
    String name;
    String address;
    String phone;
    int empId;
    EmployeeController controller;
    String startDate, startH, startM, startS, endDate, endH, endM, endS;
    
    public EmployeeTests() {
        name = "John Oliver";
        address = "Fitzroy Road, Sydney";
        phone = "0430 233 029";
        empId = 1;
        startDate = "08/07/2017";
        startH = "10";
        startM = "10";
        startS = "10";
        endH = "19";
        endM = "19";
        endS = "19";
        
        controller = new EmployeeController();
    }
    
    @BeforeClass
    public static void setupEnv() {
        Business b = new AuthController().queryBusiness("b1");
        AuthController.currentUser = b;
    }
    
    @AfterClass
    public static void destroyTestEnv() {
        AuthController.currentUser = null;
    }
    
    @Test
    public void canAddEmployees() {        
        assertNotEquals(true,controller.addEmployee("", address, phone));
        assertNotEquals(true,controller.addEmployee(name, "", phone));
        assertNotEquals(true,controller.addEmployee(name, address, ""));
        assertNotEquals(true,controller.addEmployee(name, address, name));
    }
    
    @Test(expected = Exception.class)
    public void failAddEmployeeWorkTime() {
        assertEquals(false, controller.addEmployeeWorkTime(empId,null,null,null,null,null));
        assertEquals(false, controller.addEmployeeWorkTime(empId,"","","","",""));
        assertEquals(false, controller.addEmployeeWorkTime(empId,startH,startH,startH,startH,startH));
        assertEquals(false, controller.addEmployeeWorkTime(empId, "", startH, endH, startM, endM));
        assertEquals(false, controller.addEmployeeWorkTime(empId, startDate, "", endH, startM, endM));
        assertEquals(false, controller.addEmployeeWorkTime(empId, startDate, startH, "", startM, endM));
        assertEquals(false, controller.addEmployeeWorkTime(empId, startDate, startH, endH, "", endM));
        assertEquals(false, controller.addEmployeeWorkTime(empId, startDate, startH, endH, startM, ""));
    }
}
