package rmitseprocesstools.model;
import rmitseprocesstools.Utility;

import java.time.LocalDateTime;

public class Activity {
	
        public int ActivityId;
        public int BusinessId;	
	public String Name;
        public int Duration;
        
        Utility utility = new Utility();
        
        public boolean setActivityName(String input) {
        if(utility.validateName(input)){
            Name = input;
            return true;
        }
        return false;
    }
        
        public boolean setDuration(String input) {
        try{
            Duration = Integer.parseInt(input);
            return true;
        }catch(Exception e){
            return false;
        }
    }
        
        
        
}