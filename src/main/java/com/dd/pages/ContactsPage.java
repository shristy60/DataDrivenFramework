package com.dd.pages;

import com.dd.base.TestBase;
//import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends TestBase {

    @FindBy(xpath="//div[text()='Contacts']")
    WebElement contactsLabel;

    @FindBy(name="first_name")
    WebElement firstName;

    @FindBy(name="last_name")
    WebElement lastname;

    @FindBy(xpath = "//div[@name='status']")
    WebElement status;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement btnSave;

    @FindBy(xpath = "//button[contains(text(),'Create')]")
    WebElement btnCreate;

    public ContactsPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean verifyContactsLabel(){
        return contactsLabel.isDisplayed();
    }

    public void selectContactsByName(String contactName){
        //a[text()='jay singh']//parent::td//preceding-sibling::td/div/input[@name='id']
        WebElement selectContact = driver.findElement(By.xpath("//a[contains(text(),'"+contactName+"')]//parent::td//preceding-sibling::td/div/input[@name='id']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",selectContact);
    }

    public void clickOnAddNewContact(){
        btnCreate.click();
    }

    public void createNewContact(String fName, String lName, String statusVal){
        firstName.sendKeys(fName);
        lastname.sendKeys(lName);
        //Select ddlStatus = new Select(status);
        //ddlStatus.selectByVisibleText(statusVal);
        status.sendKeys(statusVal);
        btnSave.click();
    }

}
