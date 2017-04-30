package rmitseprocesstools;

import javax.swing.JOptionPane;
import rmitseprocesstools.controller.AuthController;
import rmitseprocesstools.controller.CustomerController;
import rmitseprocesstools.view.LoginView;

public class Rmitseprocesstools {
    
    public static void main(String[] args) {
        try
        {
            LoginView view = new LoginView();
            view.setVisible(true);           
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        } 
    }
    
}
