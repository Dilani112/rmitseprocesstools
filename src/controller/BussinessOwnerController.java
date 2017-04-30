package rmitseprocesstools.controller;

import rmitseprocesstools.DbHandler;
import static rmitseprocesstools.controller.AuthController.currentUser;
import rmitseprocesstools.model.Business;
import rmitseprocesstools.model.User;
import rmitseprocesstools.model.Customer;
import rmitseprocesstools.view.UpdateInfoView;

public class BussinessOwnerController {
                                
    public boolean updateBusinessOwnerInfo(String bname,String name, String address,String phone ,String q, String a) {
        
        AuthController controller = new AuthController();
        Business n = new Business();
        n = controller.queryBusiness(currentUser.Username);
        
        if(n!=null){
            if(n.setBusinessName(bname) && n.setName(name) && n.setAddress(address)&& n.setPhone(phone) &&
                n.setQuestion(q) && n.setAnswer(a) ){
                DbHandler.SaveBusiness(n);
                currentUser = n;  
                return true;
            }            
        }    
        return false;

    }
    
    public void populateBusinessInfo() {
        
        AuthController controller = new AuthController();
        
        UpdateInfoView view = new UpdateInfoView();

        Business n = new Business();
        n = controller.queryBusiness(currentUser.Username);
        
        String bname="",name="",address="",phone="", q="", a="";
        
        if(n!=null){
            bname = n.BusinessName;
            name = n.Name;
            address=n.Address;
            phone = n.Phone;
            q=n.Question;
            a = n.Answer;
            view.defaultBusinessInfo(bname,name, address, phone, q, a);
            view.setVisible(true);
        }    
    
    }
}