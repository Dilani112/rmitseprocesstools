package rmitseprocesstools.model;
import rmitseprocesstools.Utility;

public class Customer extends User {
	public int CustomerId;
	public String Name;
	public String Address;
	public String Phone;
	public String Question;
	public String Answer;
        
        Utility utility = new Utility();
        
        public boolean setCustomerId(int input) {
		CustomerId = input;
		return true;
	}

	public boolean setName(String input) {
		if(utility.validateName(input)){
			Name = input;
			return true;
		}
		return false;
	}

	public boolean setAddress(String input) {
	    if(utility.validateAddress(input)){
	        Address = input;
	        return true;
            }
            return false;
        }

        public boolean setPhone(String input) {
            if(utility.validatePhone(input)){
            Phone = input;
            return true;
          }
          return false;
    }

    public boolean setQuestion(String question) {
	    if(!"".equals(question)){
            Question = question;
            return true;
        }
        return false;
    }

    public boolean setAnswer(String input) {
	    if(!"".equals(input)){
	        Answer = input;
	        return true;
        }
        return false;
    }

    public String getAnswer(){
	    return Answer;
    }

    public String getQuestion() {
        return Question;
    }

    public String getPhone() {
        return Phone;
    }

    public String getAddress() {
        return Address;
    }

    public String getName() {
        return Name;
    }        
        
}
