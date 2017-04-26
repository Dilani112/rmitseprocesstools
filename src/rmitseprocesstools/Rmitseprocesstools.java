package rmitseprocesstools;

import javax.swing.JOptionPane;
import rmitseprocesstools.controller.AuthController;

public class Rmitseprocesstools {
    
    public static void main(String[] args) {
        try
        {
            AuthController controller = new AuthController();
            controller.displayLoginView();
           
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        } 
    }
    
}
