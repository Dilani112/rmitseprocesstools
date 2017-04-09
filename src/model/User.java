package model;

import java.util.regex.Pattern;

public abstract class User {
	public String Username;
	public String Password;

	public boolean setUsername(String input) {
        if(Pattern.matches("^\\S+@\\S+$", input)){
            Username = input;
            return true;
        }
        return false;
    }

    public boolean setPassword(String input) {
        Password = input;
        return true;
//        return false;
    }

    public String getUsername() {
	    return Username;
    }

    public String getPassword() {
	    return Password;
    }
}
