package rmitseprocesstools.unit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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

    Connection c = null;

    @Before
    public void InitializeDbTests()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        DbHandler.SetConnection(c);
        Business b = new AuthController().queryBusiness("b1");
        AuthController.currentUser = b;
    }

    @After
    public void RollbackTestChanges()
    {
        AuthController.currentUser = null;

        try {
            c.rollback();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
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
        assertEquals(false, controller.addEmployeeWorkTime(empId,null,null,null,null,true,true,true,true,true,false,false));
        assertEquals(false, controller.addEmployeeWorkTime(empId,"","","","",true,true,true,true,true,false,false));
        assertEquals(false, controller.addEmployeeWorkTime(empId,startH,startH,startH,startH,true,true,true,true,true,false,false));
        assertEquals(false, controller.addEmployeeWorkTime(empId, "", endH, startM, endM, true,true,true,true,true,false,false));
        assertEquals(false, controller.addEmployeeWorkTime(empId, startH, "", startM, endM, true,true,true,true,true,false,false));
        assertEquals(false, controller.addEmployeeWorkTime(empId, startH, endH, "", endM, true,true,true,true,true,false,false));
        assertEquals(false, controller.addEmployeeWorkTime(empId, startH, endH, startM, "", true,true,true,true,true,false,false));
    }
}
