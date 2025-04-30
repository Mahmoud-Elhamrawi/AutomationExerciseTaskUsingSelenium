package com.TestCases;

import com.TestV3.Driver.DriverManger;
import com.TestV3.Pages.P01_LandingPage;
import com.TestV3.Pages.P02_SignInUpPage;
import com.TestV3.Pages.P03_HomePage;
import com.TestV3.Utils.DataUtils.readDataJsonFile;
import com.TestV3.Utils.LogUtils.LogUtil;
import io.qameta.allure.Step;
import org.testng.annotations.*;

import static com.TestV3.Utils.DataUtils.readDataFromPropertyFile.getProperty;

@Listeners(com.TestV3.Listeners.TestNgListener.class)
public class TC01_LoginTC {

    readDataJsonFile readDataJsonFile;


    @Step("End 2 end  flow test select products that less 1000 LE")
    @Test
    public void End2endTC() {

        new P01_LandingPage(DriverManger.getDriver())
                .navigateToLoginPage()
                .validateLoginPageUrl()
                .validateTitle();
        LogUtil.info("navigate to login page");

        new P02_SignInUpPage(DriverManger.getDriver())
                .validLogin(readDataJsonFile
                        .getJsonKeyValue("valid-Credentials.email"), readDataJsonFile.getJsonKeyValue("valid-Credentials.password"));
        LogUtil.info("after login ");

        new P03_HomePage(DriverManger.getDriver())
                .validateTextInLoginPage()
                .validateOnLoginUrl()
                .clickOnMenDiv()
                .navigateToTshirtPage()
                .assertOnText()
                .addShirtsToCart()
                .navigateToCartPage()
                .validateCartPageUrl();


    }


    //Configuration
    @BeforeMethod
    public void setUpMethod() {
        DriverManger.createDriver(getProperty("browserName"));
        new P01_LandingPage(DriverManger.getDriver()).navigateToLandingPage();


    }


    @BeforeClass
    public void setUpClass() {

        readDataJsonFile = new readDataJsonFile("loginData");
    }


    @AfterMethod
    public void tearDownMethod() {
        DriverManger.closeDriver();
    }


}
