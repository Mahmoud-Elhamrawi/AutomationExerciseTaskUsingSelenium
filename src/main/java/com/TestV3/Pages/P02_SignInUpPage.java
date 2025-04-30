package com.TestV3.Pages;

import com.TestV3.Utils.ElemntsActions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_SignInUpPage {

    //Variables
    WebDriver driver ;


    //Constructor
    public P02_SignInUpPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By email_Inp = By.cssSelector("div[class=\"login-form\"] input[name=\"email\"]");
    private final By password_Inp = By.cssSelector("div[class=\"login-form\"] input[name=\"password\"]");
    private final By login_Btn =  By.cssSelector("button[data-qa=\"login-button\"]");



    //Methods
    public P03_HomePage validLogin(String eamil , String password)
    {
        ElementActions.typeOnElement(driver,this.email_Inp,eamil);
        ElementActions.typeOnElement(driver,this.password_Inp,password);
        ElementActions.clickOnElement(driver,login_Btn);

        return new P03_HomePage(driver);
    }



    //Validations







}
