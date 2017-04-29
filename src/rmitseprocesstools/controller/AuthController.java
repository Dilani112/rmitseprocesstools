package rmitseprocesstools.controller;

import rmitseprocesstools.model.Business;
import rmitseprocesstools.model.Customer;
import rmitseprocesstools.model.User;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import rmitseprocesstools.DbHandler;

public class AuthController {
    
    public static User currentUser;
    
    public boolean register(String email, String password,String confirmpwd, String name, String address, String phone, String q, String a){
        Customer n = new Customer();
        
        if(n.setUsername(email) && n.setPassword(password) && n.setName(name) &&
           n.setAddress(address)&& n.setPhone(phone) && n.setQuestion(q) && 
               n.setAnswer(a) )
        {
            DbHandler.SaveCustomer(n);
            currentUser = n;
            return true;
        }
        
        return false;
    }

    public boolean login(String email, String password) {
        List<Customer> customers = DbHandler.GetCustomers();
        List<Business> businesses = DbHandler.GetBusinesses();

        Iterator<Customer> itr = customers.iterator();
        Iterator<Business> itrb = businesses.iterator();
     
        while(itr.hasNext()){
            Customer cur = itr.next();
            if(cur.getUsername().equals(email) && cur.getPassword().equals(password)) {
                currentUser = cur;
                return true;
            }
        }
        
        while(itrb.hasNext()){
            Business curb = itrb.next();
            if(curb.getUsername().equals(email) && curb.getPassword().equals(password)) {
                currentUser = curb;
                return true;
            }
        }
        JOptionPane.showMessageDialog(null,"Invalid Username or password. Please try again.","",JOptionPane.ERROR_MESSAGE);
        return false;
    }
   
    public boolean resetPassword(String email, String password, String confirmpwd, String ques, String ans) {
        
        Customer customer = queryCustomer(email);

        if (customer == null) {
            JOptionPane.showMessageDialog(null,"Username doesnot exist in the system. Please try again with a different username.","",JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            
            if(customer.Question.equals(ques)){
                
                if(customer.Answer.equals(ans)){                   
                    customer.setPassword(password);
                    DbHandler.SaveCustomer(customer);
                    return true;
                }else{
                       JOptionPane.showMessageDialog(null,"Invalid answer. Please try again.","",JOptionPane.ERROR_MESSAGE);
                }                     
            }else{
                JOptionPane.showMessageDialog(null,"Invalid question selected. Please select the valid question.","",JOptionPane.ERROR_MESSAGE);
                
            }          
        }
        
        return false;
    }

    public boolean logout() {
        if(currentUser != null){
            currentUser = null;
            return true;
        }
        return false;
    }     
    
    public Customer queryCustomer(String input) {
        List<Customer> customers = DbHandler.GetCustomers();

        Iterator<Customer> itr = customers.iterator();

        Customer temp;

        while(itr.hasNext()){
            temp = itr.next();
            if(temp.getUsername().equals(input)) {
                return temp;
            }
        }
        return null;
    }
    
    public Business queryBusiness(String input) {
        List<Business> businesses = DbHandler.GetBusinesses();

        Iterator<Business> itr = businesses.iterator();

        Business temp;

        while(itr.hasNext()){
            temp = itr.next();
            if(temp.getUsername().equals(input)) {
                return temp;
            }
        }
        return null;
    }
    
    public User getActiveUser() {
        return currentUser;
    }
}
