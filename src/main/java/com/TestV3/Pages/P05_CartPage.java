package com.TestV3.Pages;

import com.TestV3.Utils.BrowserActions.BrowserActions;
import com.TestV3.Utils.Validations.ValidationUtils;
import org.openqa.selenium.WebDriver;

import static com.TestV3.Utils.DataUtils.readDataFromPropertyFile.getProperty;

public class P05_CartPage {
    WebDriver driver ;
    public P05_CartPage(WebDriver driver) {
        this.driver = driver;
    }





    //Validations
    public P05_CartPage validateCartPageUrl()
    {
        ValidationUtils.validateUrl(BrowserActions.getCurrentUrl(driver), getProperty("cartPage"), "in correct Url");
        return this;
    }
}
