package com.dd.testcases;

import com.dd.base.TestBase;
import com.dd.pages.Home;
import com.dd.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    Home home;
    Logger log = Logger.getLogger(LoginTest.class);

    public LoginTest(){
        super();
    }
    @BeforeMethod
    public void setup(){
        initialization();
        loginPage = new LoginPage();
    }

    @Test
    public void loginPageTitleTest(){
        log.info("**************** Test Case Execution started ****************");
        log.info("**************** Verify Login Page Title ****************");
        String title = loginPage.validateLoginpageTitle();
        Assert.assertEquals(title,"Cogmento CRM");
    }

    @Test
    public void loginTest(){
        log.info("**************** Verify Log in to Cogmento CRM ****************");
        home = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
