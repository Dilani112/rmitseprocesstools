package rmitseprocesstools.controller;

import rmitseprocesstools.view.BussinessOwnerOperationsView;

public class BussinessOwnerController {
                
    public String CurrentUser = "username";
            
    public void displayBussinessOwnerOperationsView()
    {
        BussinessOwnerOperationsView view = new BussinessOwnerOperationsView();
        view.setVisible(true);        
    }
    
}
