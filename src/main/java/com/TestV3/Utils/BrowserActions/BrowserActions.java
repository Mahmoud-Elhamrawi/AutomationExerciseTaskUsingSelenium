package com.TestV3.Utils.BrowserActions;

import com.TestV3.Driver.DriverManger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserActions {
    //Constructor
    private BrowserActions() {}



    // Navigate to URL
    public static void navigateToUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    //get title
    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    //get current url
    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }


    //refresh page
    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }


    //close driver THREAD
    public static void closeDriver() {
        DriverManger.closeDriver();
    }





}
