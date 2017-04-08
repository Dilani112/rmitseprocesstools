package controller;

import model.User;

public class AuthController {

    private User currentUser = null;

    public User getCurrentUser() {
        return this.currentUser;
    }
    public boolean login(String email, String password) {
        return false;
    }

    public boolean register(String email, String password, String fname, String lname) {
        User usr = new User();
        if(usr.setEmail(email) && usr.setPassword(password) && usr.setFname(fname) && usr.setLname(lname)){
            this.currentUser = usr;
            return true;
        }
        return false;
    }

    public boolean checkIfActive(String email) {
        if(this.currentUser != null && this.currentUser.getEmail() == email) {
            return true;
        }
        return false;
    }

    public boolean resetPassword(String email, String password) {
        if(currentUser != null && currentUser.getEmail() == email) {
            currentUser.setPassword(password);
//            currentUser.persist();
            return true;
        }
        return false;
    }

}
