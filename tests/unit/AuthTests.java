import model.Customer;
import model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import controller.AuthController;

public class AuthTests {

    AuthController auth;

    // Test Data
    String email  = "the3jana@r.com";
    String password = "pa2ssword";
    String name = "Joh3n";
    String address = "23313 Bridge Road";
    String phone = "04132243534";
    String q = "Whats yo2ur nickname?";
    String a = "johnny3";

    public AuthTests(){
        auth = new AuthController();
    }

    @Test
    public void testRegister() {
        auth.register(email, password, name, address, phone, q, a);
        Customer usr = auth.getActiveUser();

        System.out.println(usr.getName());

        Assert.assertEquals(email, usr.getUsername());
        Assert.assertEquals(password, usr.getPassword());
        Assert.assertEquals(name, usr.getName());
        Assert.assertEquals(address, usr.getAddress());
        Assert.assertEquals(phone, usr.getPhone());
        Assert.assertEquals(q, usr.getQuestion());
        Assert.assertEquals(a, usr.getAnswer());
    }

    @Test
    public void testLogin() {

    }

    @Test
    public void testResetPassword() {

    }

    @Test
    public void testLogout() {

    }
}
