package com.TestV3.Driver;

import org.openqa.selenium.WebDriver;

public class DriverManger {


    public static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();



    public static  WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver)
    {
        driverThreadLocal.set(driver);
    }

    public static WebDriver createDriver(String browserName)
    {
        WebDriver driver = DriverFactory.getDriver(browserName);
        setDriver(driver);
        return getDriver();
    }


    public static void closeDriver() {
        getDriver().quit();
        driverThreadLocal.remove();
    }



}
