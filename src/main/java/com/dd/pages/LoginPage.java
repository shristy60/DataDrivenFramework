package com.dd.pages;

import com.dd.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //Page Factory
    //@FindBy(xpath = "//a[@href='https://ui.cogmento.com/']")
    //WebElement logIn;

    @FindBy(name="email")
    WebElement email;

    @FindBy(name = "password")
    WebElement pwd;

    @FindBy(xpath = "//div[contains(text(),'Login')]")
    WebElement loginbtn;

    //Initialize the objects
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    //Actions
    public String validateLoginpageTitle(){
        return driver.getTitle();
    }
    public Home login(String un, String pd){
        //logIn.click();
        email.sendKeys(un);
        pwd.sendKeys(pd);
        loginbtn.click();
        return new Home();
    }

}
