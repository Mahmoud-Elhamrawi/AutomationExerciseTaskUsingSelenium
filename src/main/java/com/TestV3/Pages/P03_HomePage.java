package com.TestV3.Pages;

import com.TestV3.Utils.BrowserActions.BrowserActions;
import com.TestV3.Utils.ElemntsActions.ElementActions;
import com.TestV3.Utils.Validations.ValidationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.TestV3.Utils.DataUtils.readDataFromPropertyFile.getProperty;

public class P03_HomePage {
    WebDriver driver;

    public P03_HomePage(WebDriver driver) {
        this.driver = driver;
    }


    //Locators
    private final By logout_Link = By.xpath("//header //li //a[.=' Logout']");
    private final By Men_Link = By.cssSelector("a[href=\"#Men\"]");
    private final By Tshirt_Link = By.xpath("//div[@id=\"Men\"] //a[.='Tshirts ']");


    //Methods
    public P03_HomePage clickOnMenDiv() {
        ElementActions.clickOnElement(driver, Men_Link);
        return this;
    }

    public P04_TshritPage navigateToTshirtPage() {
        ElementActions.clickOnElement(driver, Tshirt_Link);
        return new P04_TshritPage(driver);
    }


    //Validations
    public P03_HomePage validateTextInLoginPage() {
        ValidationUtils.validateElementText(ElementActions.getElementText(driver, logout_Link), getProperty("logoutText"), "text is in correct");
        return this;
    }

    public P03_HomePage validateOnLoginUrl() {
        ValidationUtils.validateUrl(BrowserActions.getCurrentUrl(driver), getProperty("HomeUrl"), "in correct Url");
        return this;
    }


}
