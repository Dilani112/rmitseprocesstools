package rmitseprocesstools.controller;

import javax.swing.JOptionPane;
import rmitseprocesstools.DbHandler;
import static rmitseprocesstools.controller.AuthController.currentUser;

import rmitseprocesstools.InfoLogger;
import rmitseprocesstools.controller.AuthController;
import rmitseprocesstools.model.Customer;
import rmitseprocesstools.model.User;
import rmitseprocesstools.view.UpdateInfoView;

import java.util.logging.Logger;


public class CustomerController {
    private final static Logger LOGGER = Logger.getLogger(InfoLogger.class.getName());

    public boolean updateCustomerInfo(String name, String address,String phone ,String q, String a) {
        LOGGER.entering(getClass().getName(), "updateCustomerInfo");

        AuthController controller = new AuthController();
        Customer n = new Customer();
        n = controller.queryCustomer(currentUser.Username);
        
        if(n!=null){
            if(n.setName(name) && n.setAddress(address)&& n.setPhone(phone) &&
                n.setQuestion(q) && n.setAnswer(a) ){
                DbHandler.SaveCustomer(n);
                currentUser = n;
                LOGGER.info("Information for Customer " + n.CustomerId + "was successfully updated.");
                return true;
            }            
        }    
        return false;     
    }  
    
    public void populateCustomerInfo() {
        
        AuthController controller = new AuthController();
        
        UpdateInfoView view = new UpdateInfoView();

        Customer n = new Customer();
        n = controller.queryCustomer(currentUser.Username);
        
        String name="",address="",phone="", q="", a="";
        
        if(n!=null){
            name = n.Name;
            address=n.Address;
            phone = n.Phone;
            q=n.Question;
            a = n.Answer;
            view.defaultCustomerInfo(name, address, phone, q, a);
            view.setVisible(true);
        }    
    
    }
    
    
}
