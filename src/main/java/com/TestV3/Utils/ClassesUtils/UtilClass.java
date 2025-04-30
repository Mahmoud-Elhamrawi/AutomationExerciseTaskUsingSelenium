package com.TestV3.Utils.ClassesUtils;

import com.TestV3.Driver.DriverManger;
import com.TestV3.Utils.AllureUtil.AllureUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class UtilClass {

    public static String screenshotPath = "test-outputs/Screenshots/";

    //take screenshot
    public static void takeScreenshot( String screenshotName) {
        try {
            File src = ((TakesScreenshot) DriverManger.getDriver()).getScreenshotAs(OutputType.FILE);
            File dest = new File(screenshotPath + screenshotName + ".png");
            FileUtils.copyFile(src, dest);
            AllureUtil.addScreenshotToAllureReport(screenshotName,dest.getPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
