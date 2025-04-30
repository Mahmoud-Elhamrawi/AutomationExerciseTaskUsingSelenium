package com.TestV3.Utils.Validations;

import org.testng.Assert;

public class ValidationUtils {


    //validate url
    public static void validateUrl(String  ActualUrl ,String ExpectedUrl, String message) {
        Assert.assertEquals(ActualUrl, ExpectedUrl, message);
    }


    //validate title
    public static void validateTitle(String  ActualTitle ,String ExpectedTitle, String message) {
        Assert.assertEquals(ActualTitle, ExpectedTitle, message);
    }


    //validate element text
    public static void validateElementText(String  ActualText ,String ExpectedText, String message) {
        Assert.assertEquals(ActualText, ExpectedText, message);
    }


}
