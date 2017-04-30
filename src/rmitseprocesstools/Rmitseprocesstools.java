package rmitseprocesstools;

import javax.swing.JOptionPane;
import rmitseprocesstools.controller.AuthController;
import rmitseprocesstools.controller.CustomerController;
import rmitseprocesstools.view.LoginView;

import java.io.IOException;

public class Rmitseprocesstools {

    public static void main(String[] args) {
        try {
            InfoLogger.setup();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("There was a problem setting up the logger.");
        }

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
