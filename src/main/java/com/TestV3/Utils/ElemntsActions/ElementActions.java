package com.TestV3.Utils.ElemntsActions;

import com.TestV3.Utils.Scrolling.Scrolling;
import com.TestV3.Utils.Waits.WaitClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementActions {

    //Constructor
    private ElementActions() {

    }


    // click on element
    public static void clickOnElement(WebDriver driver , By locator) {
        Scrolling.scrollDown(driver, locator);
        WaitClass.waitElementToBeClickable(driver, locator);
        driver.findElement(locator).click();
    }

    // type on element
    public static void typeOnElement(WebDriver driver , By locator , String value) {
        Scrolling.scrollDown(driver, locator);
        WaitClass.waitElementToBeClickable(driver, locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    //get element text
    public static String getElementText(WebDriver driver , By locator) {
        WaitClass.waitElementToBeClickable(driver, locator);
        Scrolling.scrollDown(driver, locator);
        return driver.findElement(locator).getText();
    }















}
