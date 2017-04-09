package controller;

import model.Business;
import model.Customer;
import model.User;

import java.util.Iterator;
import java.util.List;

public class AuthController {
    private Customer currentUser;

//    public AuthController() {
//        Customer n = new Customer();
//        n.setCustomerId(0);
//        n.setUsername("thejana@outlook.com");
//        n.setPassword("password");
//        n.setName("Thejana");
//        n.setAddress("295 State Road");
//        n.setPhone("0942342311");
//        n.setQuestion("What's your pet's name?");
//        n.setAnswer("Fuss");
//
//        DbHandler.SaveCustomer(n);
//    }

    public boolean register(String email, String password, String name, String address, String phone, String q, String a){
        Customer n = new Customer();

        boolean status = false;

        n.setCustomerId(0);
        status = n.setUsername(email);
        status = n.setPassword(password);
        status = n.setName(name);
        status = n.setAddress(address);
        status = n.setPhone(address);
        status = n.setQuestion(q);
        status = n.setAnswer(a);

        DbHandler.SaveCustomer(n);

        return status;
    }

    public boolean login(String email, String password) {
        List<Customer> customers = DbHandler.GetCustomers();
        List<Business> businesses = DbHandler.GetBusinesses();

        Iterator<Customer> itr = customers.iterator();

        while(itr.hasNext()){
            Customer cur = itr.next();
            if(cur.getUsername() == email && cur.getPassword() == password) {
                currentUser = cur;
                return true;
            }
        }
        return false;
    }

    private Customer queryCustomer(String input) {
        List<Customer> customers = DbHandler.GetCustomers();

        Iterator<Customer> itr = customers.iterator();

        Customer temp;

        while(itr.hasNext()){
            temp = itr.next();
            if(temp.getUsername() == input) {
                return temp;
            }
        }
        return null;
    }

//    public boolean resetPassword(String email, String password, String ques, String ans) {
//        Customer customer = queryCustomer(email);
//
//        if (customer == null) {
//            return false;
//        }
//
//        if (customer.getQuestion() == ques && customer.getAnswer() == ans) {
//            customer.setPassword(password);
//            DbHandler.SaveCustomer(customer);
//            return true;
//        }
//        return false;
//    }

    public Customer getActiveUser() {
        return currentUser;
    }

//    public boolean logout() {
//        if(currentUser != null){
//            currentUser = null;
//            return true;
//        }
//
//        return false;
//    }

}
