package com.TestV3.Pages;

import com.TestV3.Utils.ElemntsActions.ElementActions;
import com.TestV3.Utils.LogUtils.LogUtil;
import com.TestV3.Utils.Validations.ValidationUtils;
import com.TestV3.Utils.Waits.WaitClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.TestV3.Utils.DataUtils.readDataFromPropertyFile.getProperty;

public class P04_TshritPage {
    WebDriver driver;

    public P04_TshritPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By assertText_h2 = By.cssSelector("div[class=\"features_items\"] >h2");


    private final By card = By.xpath("//div[contains(@class,'productinfo')]");
    private final By continueShopping_Btn = By.cssSelector("button[data-dismiss=\"modal\"]");
    private final By cart_link = By.xpath("//header //li //a[@href=\"/view_cart\"]");


    //Methods
// create list

    public List<WebElement> tshirtList;

    public P04_TshritPage addShirtsToCart() {
        tshirtList = driver.findElements(card);
        LogUtil.info("number of products : " + tshirtList.size());  //6

        for (int i = 0; i < tshirtList.size(); i++) {
            String pprice = driver.findElement(By.xpath("(//div[contains(@class,'productinfo')] /h2)[" + (i + 1) + "]")).getText().replaceAll("[^0-9]", "");
            LogUtil.info("all prices after replace: " + pprice);
            if (Integer.parseInt(pprice) < 1000) {
                LogUtil.info("price is less than 1000 " + pprice);
                ElementActions.clickOnElement(driver, By.xpath("(//div[contains(@class,'productinfo')] )[" + (i + 1) + "] /a"));
                LogUtil.info("product that added to cart");
                WaitClass.waitElementToBeClickable(driver, continueShopping_Btn);
                try {
                    ElementActions.clickOnElement(driver, continueShopping_Btn);
                    LogUtil.info("clicking on continue btn");
                } catch (Exception e) {
                    LogUtil.warn("confirm layer not found" + e.getMessage());
                }

            }
        }
        return this;
    }


    public P05_CartPage navigateToCartPage() {
        ElementActions.clickOnElement(driver, cart_link);
        return new P05_CartPage(driver);
    }



    //Validations
    public P04_TshritPage assertOnText() {
        ValidationUtils.validateElementText(ElementActions.getElementText(driver, assertText_h2), getProperty("textInTsheirtPage"), "text is in correct");
        return this;
    }


}


/*
   WebElement prod = tshirtList.get(i);

            String price = driver.findElement(pricesOfProducts).getText().replaceAll("[^0-9]", "");
            // LogUtil.info("prices all : " + tshirtList.get(i).getText());
//            int price = Integer.parseInt(prod.getText().replaceAll("[^0-9]", ""));
//            LogUtil.info("prices : "+ price);
//            if (Integer.parseInt(price) < 1000) {
//                ElementActions.clickOnElement(driver, addToCart_Btn);
//                LogUtil.info("price selected:" + price);
//                WaitClass.waitElementToBeClickable(driver,continueShopping_Btn);
//                try {
//                    ElementActions.clickOnElement(driver, continueShopping_Btn);
//                } catch (Exception e) {
//                    LogUtil.warn("confirm layer not found"+ e.getMessage());
//                }
//                break;

 */