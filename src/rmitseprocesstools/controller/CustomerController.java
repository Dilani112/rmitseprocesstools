package rmitseprocesstools.controller;

import rmitseprocesstools.model.User;
import rmitseprocesstools.view.CustomerOperationsView;

public class CustomerController {
                
    public User CurrentUser = null;
    
    public void displayCustomerOperationsView()
    {
        CustomerOperationsView view = new CustomerOperationsView();
        view.setVisible(true);        
    }
    
}
