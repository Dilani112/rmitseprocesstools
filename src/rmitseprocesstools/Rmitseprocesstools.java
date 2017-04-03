package rmitseprocesstools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.JOptionPane;
import rmitseprocesstools.controller.BussinessOwnerController;


public class Rmitseprocesstools {


    public static void main(String[] args) {
        try
        {
            BussinessOwnerController controller = new BussinessOwnerController();
            controller.displayBussinessOwnerOperationsView();
           
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        } 
    }
    
}
