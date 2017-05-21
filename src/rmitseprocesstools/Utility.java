package rmitseprocesstools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Utility {
    
    
    public Boolean validateEmail(String email)
    {
        if (email!=null)
        {
            String emailRegex = "[\\w-]+@([\\w-]+\\.)+[\\w-]+";

            Pattern emailPattern = Pattern.compile(emailRegex);
            Matcher emailMatcher = emailPattern.matcher(email);

            if(emailMatcher.matches()){        

                return true;
            }
        }
       
       JOptionPane.showMessageDialog(null,"Invalid email address. Please try again.","",JOptionPane.ERROR_MESSAGE);
       return false;
    }
    
    
    public Boolean validatePhone(String phone)
    {
        if (phone!=null)
        {
            String phoneRegex = "^\\({0,1}((0|\\+61)(2|4|3|7|8)){0,1}\\){0,1}(\\ |-){0,1}[0-9]{2}(\\ |-){0,1}[0-9]{2}(\\ |-){0,1}[0-9]{1}(\\ |-){0,1}[0-9]{3}$";

            Pattern phonePattern = Pattern.compile(phoneRegex);
            Matcher phoneMatcher = phonePattern.matcher(phone);

            if(phoneMatcher.matches()){        

                return true;
            }
        }
        
       JOptionPane.showMessageDialog(null,"Invalid phone number. Please try following formats."+"\n 0407222111, (03) 2222 1111, +61433112222, 02 9111 2222, 0403 111 222, 91122233","",JOptionPane.ERROR_MESSAGE);
       return false;
    }
    
    
    public Boolean validateName(String text)
    {
        if (text!=null)
        {        
            String stringRegex = "[a-zA-Z\\-'\\s]+";
            Pattern stringPattern = Pattern.compile(stringRegex);
            Matcher stringMatcher = stringPattern.matcher(text);
            
            if(stringMatcher.matches()){        

                return true;
            }
        }
       
       JOptionPane.showMessageDialog(null,"Invalid name. Please try again.","",JOptionPane.ERROR_MESSAGE);
       return false;
    }
    
    public Boolean validateAddress(String text)
    {
        if (text != null && text != "")
        {        
            String stringRegex = "[a-zA-Z0-9\\-'\\s\\,\\.\\#\\/]+";
            Pattern stringPattern = Pattern.compile(stringRegex);
            Matcher stringMatcher = stringPattern.matcher(text);
            
            if(stringMatcher.matches()){        
                
                return true;
            }
        }
       
       JOptionPane.showMessageDialog(null,"Invalid address. Please try again.","",
                                    JOptionPane.ERROR_MESSAGE);
       return false;
    }
    
    public Boolean validatePassword(String text)
    {
        if (text!=null)
        {        
            String stringRegex = ".{6,}";
            Pattern stringPattern = Pattern.compile(stringRegex);
            Matcher stringMatcher = stringPattern.matcher(text);
            
            if(stringMatcher.matches()){        

                return true;
            }
        }
       
       JOptionPane.showMessageDialog(null,"Weak password. Password must be atleast 6 characters long.","",JOptionPane.ERROR_MESSAGE);
       return false;
    }
    
    
}