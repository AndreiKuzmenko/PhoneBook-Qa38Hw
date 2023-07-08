package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests  extends TestBase{
    @BeforeMethod
    public  void preconditions(){

        if(!app.getUser().isLogged()){
            String email = "ref@gmail.com" ,password = "$Qwe1234";
            app.getUser(). openLoginForm();
            app.getUser(). fillLoginForm(email, password);
            app.getUser(). submitLogin();
        }
    }

    @Test
    public void removeOneContactPositive(){
        int res = app.getHelperContact().removeOneContact();
        Assert.assertEquals(-1, res);
    }

//    @Test
//    public void removeAllContactsPositive(){
//        app.getHelperContact().removeAllContacts();
//        Assert.assertTrue(app.getHelperContact().isNoContacts());
//    }
}
