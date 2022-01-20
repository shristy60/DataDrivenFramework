package com.dd.pages;

import com.dd.base.TestBase;
import com.dd.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;

public class Home extends TestBase {
    TestUtil testUtil;

    @FindBy(xpath = "//div/span[contains(text(),'Shristy Chouhan')]")
    WebElement userNameLabel;

    //div[@id='main-nav']/a[@href='/contacts']/span[contains(text(),'Contacts')]
    //div/a[@href='/contacts


    @FindBy(xpath="//a[@href='/contacts']/span[contains(text(),'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath="//a[@href='/deals']")
    WebElement dealsLink;

    @FindBy(xpath="//a[@href='/tasks']")
    WebElement tasksLink;

    //Initializing the Home page objects
    public Home(){
        PageFactory.initElements(driver,this);
        testUtil = new TestUtil();
    }

    public String verifyHomePageTitle(){
        return driver.getTitle();
    }
    public boolean verifyUserName(){
        return userNameLabel.isDisplayed();
    }

    public ContactsPage clickOnContacts(){
        //JavascriptExecutor js = (JavascriptExecutor)driver;
        //js.executeScript("scroll(0,300)");
        //js.executeScript("arguments[0].scrollIntoView(true);",contactsLink);
        testUtil.jsScrollIntoView(contactsLink);
        //contactsLink.click();
        //div/span[@class='user-display']
        driver.findElement(By.xpath("//div/span[@class='user-display']")).click();
        return new ContactsPage();
    }

    public DealsPage clickOnDeals(){
        dealsLink.click();
        return new DealsPage();
    }
    public TasksPage clickOnTasks(){
        tasksLink.click();
        return new TasksPage();
    }

}
