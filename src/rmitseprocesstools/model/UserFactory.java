/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmitseprocesstools.model;

/**
 *
 * @author Thejana
 */
public class UserFactory {
    public User createNewUser(String userType) {
        switch (userType.toUpperCase()) {
            case "BUSINESS": {
                return new Business();
            }
            case "CUSTOMER": {
                return new Customer();
            }
        }
        return null;
    }
}
