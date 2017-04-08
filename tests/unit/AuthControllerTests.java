import controller.AuthController;
import model.User;
import org.junit.Assert;
import org.junit.Test;

public class AuthControllerTests {

    //    Mock data
    private String email = "thejana@rmit.edu.au";
    private String password = "password";
    private String fname = "Jason";
    private String lname = "Appleseed";

    private AuthController ctrl = new AuthController();

    @Test
    public void testLogin() {
        Assert.assertEquals(true,ctrl.login(this.email, this.password));
        Assert.assertNotEquals(true, ctrl.login("",""));
        Assert.assertNotEquals(true, ctrl.login("124321",""));
        Assert.assertNotEquals(true, ctrl.login("1231231", this.password));
        Assert.assertNotEquals(true, ctrl.login(this.email, ""));
        Assert.assertNotEquals(true, ctrl.login(this.email, "123i1u32h1iu3"));
    }

    @Test
    public void testRegister() {
        Assert.assertEquals(true, ctrl.register(this.email, this.password, this.fname, this.lname));
        User usr = ctrl.getCurrentUser();
        Assert.assertNotEquals(null, usr);
        Assert.assertEquals(new User().getClass(), usr.getClass());
        Assert.assertEquals(this.email, usr.getEmail());
        Assert.assertEquals(this.password, usr.getPassword());
        Assert.assertEquals(this.fname, usr.getFname());
        Assert.assertEquals(this.lname, usr.getLname());
    }

    @Test
    public void testCheckIfActive() {
        ctrl.login(this.email, this.password);
        User usr = ctrl.getCurrentUser();
        Assert.assertEquals(usr.getClass(), new User().getClass());
        Assert.assertNotEquals(null, usr);
        Assert.assertEquals(true, ctrl.checkIfActive(this.email));
        ctrl.login(this.email,"");
        usr = ctrl.getCurrentUser();
        Assert.assertEquals(null, usr);
        Assert.assertNotEquals(new User().getClass(), usr.getClass());
        Assert.assertNotEquals(true, ctrl.checkIfActive(this.email));
    }

    @Test
    public void testResetPassword() {
        Assert.assertEquals(true,ctrl.resetPassword(this.email, this.password));
        Assert.assertNotEquals(true, ctrl.resetPassword("", this.password));
    }
}
