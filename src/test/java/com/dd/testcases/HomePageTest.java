package com.dd.testcases;

import com.dd.base.TestBase;
import com.dd.pages.ContactsPage;
import com.dd.pages.Home;
import com.dd.pages.LoginPage;
import com.dd.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    Home home;
    ContactsPage contactsPage;
    //calling superclass by creating constructor
    public HomePageTest(){
        super();
    }
    //test cases should be independent with each other
    //before each test case - launch the browser and login
    //after each test case - quit the browser
    @BeforeMethod
    public void setup(){
        initialization();
        loginPage = new LoginPage();
        contactsPage = new ContactsPage();
        home = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test(priority = 1,enabled = true)
    public void verifyHomePageTest(){
        String homePageTitle = home.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle,"Cogmento CRM","Home Page title not matched");
    }

    @Test(priority = 2,enabled = true)
    public void verifyUserNameTes(){
        Assert.assertTrue(home.verifyUserName());
    }

    @Test(priority = 3)
    public void verifyContactsLinkTest(){
        contactsPage = home.clickOnContacts();
    }

    @AfterMethod(enabled = true)
    public void tearDown(){
        driver.quit();
    }
}
