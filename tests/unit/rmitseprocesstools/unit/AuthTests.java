package rmitseprocesstools.unit;

import rmitseprocesstools.DbHandler;
import rmitseprocesstools.model.Customer;
import rmitseprocesstools.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import rmitseprocesstools.controller.AuthController;
import rmitseprocesstools.model.Business;

public class AuthTests {
    Connection c;
    AuthController auth;

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
        auth = new AuthController();
    }

    @After
    public void RollbackTestChanges()
    {
        try {
            c.rollback();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Test
    public void testRegister() {
        auth.register("c2@c2.com","password", "password",
                "name", "address", "0422222222",
                "q", "a");
        Customer usr = auth.queryCustomer("c2@c2.com");

        Assert.assertEquals("c2@c2.com", usr.getUsername());
        Assert.assertEquals("password", usr.getPassword());
        Assert.assertEquals("name", usr.getName());
        Assert.assertEquals("address", usr.getAddress());
        Assert.assertEquals("0422222222", usr.getPhone());
        Assert.assertEquals("q", usr.getQuestion());
        Assert.assertEquals("a", usr.getAnswer());
    }

    @Test
    public void testBusinessRegister() {
        auth.registerBusiness("b3@b3.com",
                "password", "bname",
                "ownerName", "address",
                "0422222222", "q", "a", "start", "end");

        Business usr = auth.queryBusiness("b3@b3.com");

        Assert.assertNotNull(usr);
        Assert.assertEquals("b3@b3.com", usr.getUsername());
        Assert.assertEquals("bname", usr.getBusinessName());
        Assert.assertEquals("ownerName", usr.getName());
    }

    @Test
    public void testCustomerLogin() {
        auth.login("customer1", "password");
        Customer usr = auth.queryCustomer("customer1");
        
        Assert.assertEquals("customer1", usr.getUsername());
        Assert.assertEquals("password", usr.getPassword());
        Assert.assertEquals("Customer 1", usr.getName());
        Assert.assertEquals("295 State Road", usr.getAddress());
        Assert.assertEquals("0942342311", usr.getPhone());
        Assert.assertEquals("What's your pet's name?", usr.getQuestion());
        Assert.assertEquals("Fuss", usr.getAnswer());
    }
    
    @Test
    public void testBusinessLogin() {
        auth.login("business1", "password");
        Customer usr = auth.queryCustomer("customer1");
        
        Assert.assertEquals("customer1", usr.getUsername());
        Assert.assertEquals("password", usr.getPassword());
    }
    
    @Test
    public void testLogout() {
        auth.logout();
        Assert.assertNull(AuthController.currentUser);
    }
}
