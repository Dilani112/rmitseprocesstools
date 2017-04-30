import rmitseprocesstools.model.Customer;
import rmitseprocesstools.model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import rmitseprocesstools.controller.AuthController;

public class AuthTests {

    AuthController auth;

    // Test Data
    String email  = "the3jana@r.com";
    String password = "pa2ssword";
    String name = "John";
    String address = "23313 Bridge Road";
    String phone = "0410093924";
    String q = "Whats your nickname?";
    String a = "johnny3";

    public AuthTests(){
        auth = new AuthController();
    }

    @Test
    public void testRegister() {
        auth.register(email,password,password, name, address, phone, q, a);
        Customer usr = auth.queryCustomer(email);

        Assert.assertEquals(email, usr.getUsername());
        Assert.assertEquals(password, usr.getPassword());
        Assert.assertEquals(name, usr.getName());
        Assert.assertEquals(address, usr.getAddress());
        Assert.assertEquals(phone, usr.getPhone());
        Assert.assertEquals(q, usr.getQuestion());
        Assert.assertEquals(a, usr.getAnswer());
    }

    @Test
    public void testCustomerLogin() {
        auth.login(email, password);
        Customer usr = auth.queryCustomer(email);
        
        Assert.assertEquals(email, usr.getUsername());
        Assert.assertEquals(password, usr.getPassword());
        Assert.assertEquals(name, usr.getName());
        Assert.assertEquals(address, usr.getAddress());
        Assert.assertEquals(phone, usr.getPhone());
        Assert.assertEquals(q, usr.getQuestion());
        Assert.assertEquals(a, usr.getAnswer());
    }
    
    @Test
    public void testBusinessLogin() {
        auth.login("b1", password);
        Customer usr = auth.queryCustomer(email);
        
        Assert.assertEquals("b1", usr.getUsername());
        Assert.assertEquals(password, usr.getPassword());
    }

    @Test
    public void testResetPassword() {
        
    }

    @Test
    public void testLogout() {

    }
}
