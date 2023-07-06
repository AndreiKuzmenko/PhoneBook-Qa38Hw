package tests;

import models.AddContact;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TestBase {

    @BeforeMethod
    public void precondition() {

        if (app.getUser().isLogged() == false) app.getUser().
                login(new User().withEmail("ref@gmail.com").withPassword("$Qwe1234"));

    }

    @Test
    public void addNewContactPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        AddContact addContact = AddContact.builder()
                .name("Joe")
                .lastName("Smith")
                .phone("2223332333" + i)
                .email("anpch@g.com")
                .address("New York")
                .description("New description")
                .build();

        app.getAddContact().openAddForm();
        app.getAddContact().fillAddForm(addContact);
        app.getAddContact().openAddForm();

    }
}
