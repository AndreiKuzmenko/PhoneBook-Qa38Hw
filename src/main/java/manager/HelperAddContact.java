package manager;

import models.AddContact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperAddContact extends HelperBase{
    public HelperAddContact(WebDriver wd) {
        super(wd);
    }
    public void openAddForm() {
pause(3000);

  wd.findElement(By.xpath("//div[contains(@class,'add_main__1tbl_')]")).click();
        }

public void fillAddForm(AddContact addContact) {
    type(By.xpath("//input[@placeholder='Name']"), addContact.getName());
    type(By.xpath("//input[@placeholder='Last Name']"), addContact.getLastName());
    type(By.xpath("//input[@placeholder='Phone']"), addContact.getPhone());
    type(By.xpath("//input[@placeholder='email']"), addContact.getEmail());
    type(By.xpath("//input[@placeholder='Address']"), addContact.getAddress());
    type(By.xpath("//input[@placeholder='description']"), addContact.getDescription());


}
public void saveAddForm() {
    click(By.xpath("//button[@fdprocessedid='gnolic']"));
}
}
