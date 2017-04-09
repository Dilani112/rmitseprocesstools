package model;


import java.util.regex.Pattern;

public class Customer extends User {
	public int CustomerId;
	public String Name;
	public String Address;
	public String Phone;
	public String Question;
	public String Answer;

	public boolean setCustomerId(int input) {
		CustomerId = input;
		return true;
	}

	public boolean setName(String input) {
//		if(Pattern.matches("^[A-Za-z]$",input)){
			Name = input;
			return true;
//		}

//		return false;
	}

	public boolean setAddress(String input) {
//	    if(Pattern.matches("^[A-Za-z0-9,]$", input)){
	        Address = input;
	        return true;
//        }

//        return false;
    }

    public boolean setPhone(String input) {
//        if(Pattern.matches("^[0-9]$", input)){
            Phone = input;
            return true;
//        }
//        return false;
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
