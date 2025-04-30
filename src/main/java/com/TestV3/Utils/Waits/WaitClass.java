package com.TestV3.Utils.Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitClass {
    //Constructor
    private WaitClass() {}




    //Methods
    // Wait Ele to be Exist
    public static WebElement waitElementToBeExist(WebDriver driver , By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver1 -> driver1.findElement(locator));

    };

    //wait ele to be present
    public static WebElement waitElementToBePresent(WebDriver driver , By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver1 ->
                {
                     WebElement ele = waitElementToBeExist(driver, locator);
                    return ele.isDisplayed() ? ele : null;
                });
    }


    //wait ele to be clickable
    public static WebElement waitElementToBeClickable(WebDriver driver , By locator) {
        return  new WebDriverWait(driver,Duration.ofSeconds(10)).until(
                driver1 ->  {
                    WebElement ele = waitElementToBePresent(driver, locator);
                    return ele.isEnabled() ? ele : null;
                }
        );
    }





}




