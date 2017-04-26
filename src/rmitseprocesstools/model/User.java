package rmitseprocesstools.model;
import rmitseprocesstools.Utility;


public abstract class User {
	public String Username;
	public String Password;
        
        Utility utility = new Utility();
        
    public boolean setUsername(String input) {
        if(utility.validateEmail(input)){
            Username = input;
            return true;
        }
        return false;
    }

    public boolean setPassword(String input) {
        if(utility.validatePassword(input)){
        Password = input;
        return true;
        }
        return false;
    }

    public String getUsername() {
	    return Username;
    }

    public String getPassword() {
	    return Password;
    }


}