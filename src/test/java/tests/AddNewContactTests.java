package tests;

import models.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{

Logger logger = LoggerFactory.getLogger(AddNewContactTests.class);

    @BeforeMethod
    public  void preconditions(){

        if(!app.getUser().isLogged()){
            String email = "ref@gmail.com" ,password = "$Qwe1234";
            app.getUser(). openLoginForm();
            app.getUser(). fillLoginForm(email, password);
            app.getUser(). submitLogin();
        }
    }


    @Test(invocationCount = 3)

    public void addNewContactPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Joy")
                .lastName("Fora")
                .phone("0454545" + i)
                .email("123asd_" + i + "@gmail.com")
                .address("Holon")
                .description("step by step")
                .build();

logger.info("Phone number is" + contact.getPhone());
app.getHelperContact().openContactForm();
app.getHelperContact().fillContactForm(contact);
app.getHelperContact().submitContactForm();
app.getHelperContact().pause(5000);

        Assert.assertTrue(app.getHelperContact().isContactCreated(contact));
    }

    @Test

    public void removeContact ( String user, int quantity)
    {
for( Contact contact : app.getContact())
{ if(contact.getUser() == user)
{
int current = contact.getQuantity();
if (current >= quantity)
{
    current -= quantity;
}
else {
    System.out.println("Only" + current + "amount removed");
    current = 0;
}
    contact.setQuantity(current);
    return ;

}
}
    }




}
