package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

//    WebDriver wd;
//
//@BeforeMethod
//public void init(){
//    wd = new ChromeDriver();
//    wd.navigate().to("https://telranedu.web.app/home");
//    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//}
@BeforeMethod(alwaysRun = true)
public void precondition() {
   if(app.getUser().isLogged()){
       app.getUser().logout();
   }
}

   @Test
  public void loginPositiveTest() {

       String email = "ref@gmail.com" ,password = "$Qwe1234";
       app.getUser(). openLoginForm();
       app.getUser(). fillLoginForm(email, password);
       app.getUser(). submitLogin();
       app.getUser(). pause(3000);
       Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("ref@gmail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Qwe1234");
//
//        wd.findElement(By.xpath("//button[1]")).click();
//        pause(3000);
//        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
//

   }
    @Test(groups = {"smoke","positive"})
    public void loginPositiveTestBase() {

      String email = "ref@gmail.com" ,password = "$Qwe1234";
        app.getUser(). openLoginForm();
        app.getUser(). fillLoginForm(email, password);
        app.getUser(). submitLogin();
        app.getUser(). pause(3000);
       // Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }
//    @Test
//    public void loginNegTestWrongEmail(){
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("refgmail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Qwe1234");
//
//        wd.findElement(By.xpath("//button[1]")).click();
//
//
//    }
//    @Test
//    public void loginNegTestWrongPassword() {
//
//        String email = "ref@gmail.com" ,password = "$we1234";
//        openLoginForm();
//        fillLoginForm(email,password);
//        submitLogin();
//
//
//
//    }
@Test(groups = {"regress","negative"})
public void loginNegativeTestBase() {

    String email = "refmail.com", password = "$Qwe1234";
    app.getUser().openLoginForm();
    app.getUser().fillLoginForm(email, password);
    app.getUser().submitLogin();
    //  app.getUser(). pause(3000);
    Assert.assertTrue(app.getUser().isWrongFormatMassage());
    Assert.assertTrue(app.getUser().isAlertPresent());
}

    @AfterMethod(alwaysRun = true)
    public void tearDown(){

    }
}
