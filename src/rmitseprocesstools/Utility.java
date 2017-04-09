package rmitseprocesstools;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class Utility {
    
    
    public Boolean validateEmail(String email)
    {
        String emailRegex = "^[\\\\w!#$%&'*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$";
       
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);
        
        if(emailMatcher.matches()){        
            
            return true;
        }
       
       JOptionPane.showMessageDialog(null,"Invalid email address. Please try again.","",JOptionPane.ERROR_MESSAGE);
       return false;
    }
    
    
    public Boolean validatePhone(String phone)
    {
        String phoneRegex = "^\\({0,1}((0|\\+61)(2|4|3|7|8)){0,1}\\){0,1}(\\ |-){0,1}[0-9]{2}(\\ |-){0,1}[0-9]{2}(\\ |-){0,1}[0-9]{1}(\\ |-){0,1}[0-9]{3}$";
       
        Pattern phonePattern = Pattern.compile(phoneRegex);
        Matcher phoneMatcher = phonePattern.matcher(phone);
        
        if(phoneMatcher.matches()){        
            
            return true;
        }
        
       JOptionPane.showMessageDialog(null,"Invalid phone number. Please try following formats."+"\n 0407222111, (03) 2222 1111, +61433112222, 02 9111 2222, 0403 111 222, 91122233","",JOptionPane.ERROR_MESSAGE);
       return false;
    }
}