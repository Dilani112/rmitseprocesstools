package rmitseprocesstools.controller;

import rmitseprocesstools.model.Activity;
import rmitseprocesstools.DbHandler;
import rmitseprocesstools.InfoLogger;
import java.util.logging.Logger;
import java.util.List;

public class ActivityController {
    private final static Logger LOGGER = Logger.getLogger(InfoLogger.class.getName());
   
   public boolean addActivity(String name,String duration){
        Activity n = new Activity();
        
        if(n.setActivityName(name) && n.setDuration(duration))
        {
            DbHandler.SaveActivity(n);
            System.out.println("Activity added successfully!");
            return true;
        }
        System.out.println("The activity is not added! Please try again");
        return false;
   }
   
   public boolean editActivity(String name,String duration){
       LOGGER.entering(getClass().getName(), "updateActivityInfo");
        Activity n = new Activity();
        if(n!=null){
            if(n.setActivityName(name) && n.setDuration(duration)){
                DbHandler.SaveActivity(n);
                LOGGER.info("Activity for " + n.BusinessId + "was successfully updated.");
                return true;
            }            
        }

        return false;

    }
    
}
