package tests;

import manager.TestNgListener;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(TestNgListener.class)
public class Registration  extends TestBase {
//       WebDriver wd;

//    @BeforeMethod
//    public void precondition() {
//        if(app.getUser().isLogged()){
//            app.getUser().logout();
//        }
//    }

//
//    @BeforeMethod
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//    }
    @Test
   public void RegPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withEmail("ref" + i + "@gmail.com")
                .withPassword("$Qwe1234")
                ;

        app.getUser(). openLoginForm();
        app.getUser(). fillLoginForm(user.getEmail(), user.getPassword());
        app.getUser(). submitRegistration();
        app.getUser(). pause(5000);
        // Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//        int i = (int)(System.currentTimeMillis()/1000)%3600;
//
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("ref" +i + "@gmail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Qwe1234");
//
//        wd.findElement(By.xpath("//button[2]")).click();
//        //        Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
////        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
//        pause(5000);
//        Assert.assertTrue(isElementPresent(By.xpath("//button")));
//    }
//    @Test
//    public void RegNegative(){
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//        int i = (int)(System.currentTimeMillis()/1000)%3600;
//
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("ref" +i + "gmail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Qwe1234");
//
//        wd.findElement(By.xpath("//button[2]")).click();
//      //  Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
//        Assert.assertTrue(isElementPresent(By.xpath("//button")));
//    }
//    @Test
//    public void RegNegative2(){
//        int i = (int)(System.currentTimeMillis()/1000)%3600;
//        String email = "ref" + i + "gmail.com" ,password = "$Qwe1234";
//
//    openLoginForm();
//    fillLoginForm(email,password);
//    submitRegistration();
//
//    }
    @Test
    public void RegNegative3() {
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "ref" + i + "@gmail.com" ,password = "Qwe1234";

       app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email,password);
        app.getUser().submitRegistration();

    }
 @AfterMethod
public void tearDown(){

}
}
