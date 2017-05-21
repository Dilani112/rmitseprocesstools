package rmitseprocesstools.unit;

import rmitseprocesstools.model.Customer;
import rmitseprocesstools.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Assert;
import org.junit.Test;
import java.util.Map;
import rmitseprocesstools.controller.AuthController;
import rmitseprocesstools.model.Business;

public class AuthTests {

    AuthController auth;
    Map<String,String> UserData;
    Map<String,String> BusinessData;

    public AuthTests(){
        // Fake User Data
        UserData.put("email","the3jana@r.com");
        UserData.put("password","password");
        UserData.put("name","John");
        UserData.put("address","23313 Bridge Road");
        UserData.put("phone","0410093924");
        UserData.put("q","Whats your nickname?");
        UserData.put("a","johnny3");
  
        // Fake Business Data       
        BusinessData.put("username", "business123");
        BusinessData.put("password", UserData.get("password"));
        BusinessData.put("bname", "Sample Construction");
        BusinessData.put("ownerName", "Jake Westrip");
        BusinessData.put("address", UserData.get("address"));
        BusinessData.put("phone", UserData.get("phone"));
        BusinessData.put("q", UserData.get("q"));
        BusinessData.put("a", UserData.get("a"));
        
        auth = new AuthController();
    }
    
    @Test
    public void testRegister() {
        auth.register(UserData.get("email"),UserData.get("password"),UserData.get("password"), 
                UserData.get("name"), UserData.get("address"), UserData.get("phone"), 
                UserData.get("q"), UserData.get("a"));
        Customer usr = auth.queryCustomer(UserData.get("email"));

        Assert.assertEquals(UserData.get("email"), usr.getUsername());
        Assert.assertEquals(UserData.get("password"), usr.getPassword());
        Assert.assertEquals(UserData.get("name"), usr.getName());
        Assert.assertEquals(UserData.get("address"), usr.getAddress());
        Assert.assertEquals(UserData.get("phone"), usr.getPhone());
        Assert.assertEquals(UserData.get("q"), usr.getQuestion());
        Assert.assertEquals(UserData.get("a"), usr.getAnswer());
    }

    @Test
    public void testCustomerLogin() {
        auth.login(UserData.get("email"), UserData.get("password"));
        Customer usr = auth.queryCustomer(UserData.get("email"));
        
        Assert.assertEquals(UserData.get("email"), usr.getUsername());
        Assert.assertEquals(UserData.get("password"), usr.getPassword());
        Assert.assertEquals(UserData.get("name"), usr.getName());
        Assert.assertEquals(UserData.get("address"), usr.getAddress());
        Assert.assertEquals(UserData.get("phone"), usr.getPhone());
        Assert.assertEquals(UserData.get("q"), usr.getQuestion());
        Assert.assertEquals(UserData.get("a"), usr.getAnswer());
    }
    
    @Test
    public void testBusinessLogin() {
        auth.login("b1", UserData.get("password"));
        Customer usr = auth.queryCustomer(UserData.get("a"));
        
        Assert.assertEquals("b1", usr.getUsername());
        Assert.assertEquals(UserData.get("password"), usr.getPassword());
    }
    
    @Test
    public void testBusinessRegister() {
        auth.registerBusiness(BusinessData.get("username"),
                    BusinessData.get("password"), BusinessData.get("bname"), 
                    BusinessData.get("ownerName"), BusinessData.get("address"), 
                    BusinessData.get("phone"), BusinessData.get("q"), BusinessData.get("a"));
        
        Business usr = auth.queryBusiness(BusinessData.get("username"));
        
        Assert.assertNotNull(usr);
        Assert.assertEquals(BusinessData.get("username"), usr.getUsername());
        Assert.assertEquals(BusinessData.get("bname"), usr.getBusinessName());
        Assert.assertEquals(BusinessData.get("ownerName"), usr.getName());
    }
}
