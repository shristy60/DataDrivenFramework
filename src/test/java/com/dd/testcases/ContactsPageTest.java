package com.dd.testcases;

import com.dd.base.TestBase;
import com.dd.pages.ContactsPage;
import com.dd.pages.Home;
import com.dd.pages.LoginPage;
import com.dd.util.TestUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {
    LoginPage loginPage;
    Home home;
    ContactsPage contactsPage;
    TestUtil testUtil;

    String sheetName = "Contacts";
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

    @DataProvider
    public Object[][] getCRMTestData(){
        Object data[][] = testUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 3, dataProvider = "getCRMTestData", enabled = false)
    public void createContactTest(String firstName, String lastName, String status){
        contactsPage.clickOnAddNewContact();
        contactsPage.createNewContact(firstName,lastName,status);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
