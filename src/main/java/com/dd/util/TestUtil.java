package com.dd.util;

import com.dd.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestUtil extends TestBase {
     public static long PAGE_LOAD = 20;
     public static long IMPLICIT_WAIT = 10;

     public void switchToFrame(){
          driver.switchTo().frame("main-nav");
     }

     public void jsScrollIntoView(WebElement element){
          JavascriptExecutor js = (JavascriptExecutor)driver;
          js.executeScript("arguments[0].scrollIntoView(true);",element);
          element.click();
     }

     public void actions(WebElement element){
          Actions action = new Actions(driver);
          //Action mouseOver = action.moveToElement(element).click().perform();
          action.moveToElement(element).click().perform();
     }
}
