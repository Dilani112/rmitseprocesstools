package rmitseprocesstools.controller;

import rmitseprocesstools.model.User;
import rmitseprocesstools.view.BussinessOwnerOperationsView;


public class BussinessOwnerController {
                            
    public User CurrentUser = null;
    
    public void displayBussinessOwnerOperationsView()
    {
        BussinessOwnerOperationsView view = new BussinessOwnerOperationsView();
        view.setVisible(true);        
    }
    
}
