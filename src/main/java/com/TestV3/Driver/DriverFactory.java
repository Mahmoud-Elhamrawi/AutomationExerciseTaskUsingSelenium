package com.TestV3.Driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;

import static com.TestV3.Utils.DataUtils.readDataFromPropertyFile.getProperty;

public class DriverFactory {


    //Constructor
    private DriverFactory() {
    }

    public static WebDriver getDriver(String browser) {

        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = getChromeOptions();

                Map<String, Object> chromePreferences = Map.of(
                        "profile.default_content_setting_values.notifications", 2,
                        "credentials_enable_service", false,
                        "profile.password_manager_enabled", false,
                        "autofill.enabled", false
                );
         chromeOptions.setExperimentalOption("prefs", chromePreferences);


                return new ChromeDriver(chromeOptions);

            case "firefox":
                return new FirefoxDriver();
            default:
                return new EdgeDriver();


        }


    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions   chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        if(!getProperty("executionType").equalsIgnoreCase("local"))
        {
            chromeOptions.addArguments("--headless");
        }
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL)  ;
        return chromeOptions;
    }


}
