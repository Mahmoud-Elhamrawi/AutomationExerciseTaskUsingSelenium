package com.TestV3.Pages;

import com.TestV3.Utils.BrowserActions.BrowserActions;
import com.TestV3.Utils.ElemntsActions.ElementActions;
import com.TestV3.Utils.LogUtils.LogUtil;
import com.TestV3.Utils.Validations.ValidationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.TestV3.Utils.DataUtils.readDataFromPropertyFile.getProperty;

public class P01_LandingPage {
    //Variables
    WebDriver driver;


    //Constructor
    public P01_LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By login_link = By.xpath("//header //li //a[.=' Signup / Login']");


    //Methods
    //navigate to landing page
    public void navigateToLandingPage() {
        BrowserActions.navigateToUrl(driver, getProperty("baseUrl"));
        LogUtil.info("Navigated to landing page - " + getProperty("baseUrl"));
    }

    //navigate to login page
    public P01_LandingPage navigateToLoginPage() {
        ElementActions.clickOnElement(driver, this.login_link);
        LogUtil.info("Navigated to login page");
        return this;
    }


    //Validations
    public P01_LandingPage validateLoginPageUrl() {
        ValidationUtils.validateUrl(BrowserActions.getCurrentUrl(driver), getProperty("loginPage"), "Login page url is not correct");
        return this;
    }

    public P01_LandingPage validateTitle() {
        ValidationUtils.validateTitle(BrowserActions.getTitle(driver), getProperty("pageTitle"), "Title is not correct");
        return this;
    }


}
