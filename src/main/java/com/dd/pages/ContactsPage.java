package com.dd.pages;

import com.dd.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {

    @FindBy(xpath="//div[text()='Contacts']")
    WebElement contactsLabel;

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

}
