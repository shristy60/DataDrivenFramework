package com.dd.testcases;

import com.dd.base.TestBase;
import com.dd.pages.ContactsPage;
import com.dd.pages.Home;
import com.dd.pages.LoginPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {
    LoginPage loginPage;
    Home home;
    ContactsPage contactsPage;
    Logger log = Logger.getLogger(ContactsPageTest.class);
    public ContactsPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        loginPage = new LoginPage();
        contactsPage = new ContactsPage();
        home = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        contactsPage = home.clickOnContacts();
    }

    @Test(priority = 1,enabled = true)
    public void verifyContactsPageLabelTest(){
        log.info("***************** Verify Contacts Page label ****************");
        Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing on the page");
    }

    @Test(priority = 2)
    public void selectContactsTest(){
        log.info("************** Selecting Contact by Name ***************");
        //Thread.sleep(5000);
        contactsPage.selectContactsByName("jay singh");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
