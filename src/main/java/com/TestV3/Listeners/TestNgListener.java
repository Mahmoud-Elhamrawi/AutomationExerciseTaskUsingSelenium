package com.TestV3.Listeners;

import com.TestV3.Driver.DriverManger;
import com.TestV3.Utils.AllureUtil.AllureUtil;
import com.TestV3.Utils.ClassesUtils.UtilClass;
import com.TestV3.Utils.DataUtils.readDataFromPropertyFile;
import com.TestV3.Utils.FileUtil.FileUtils;
import com.TestV3.Utils.LogUtils.LogUtil;
import org.testng.*;

import java.io.File;

public class TestNgListener implements ITestListener, IInvokedMethodListener, IExecutionListener {
    File allureResults = new File("test-outputs/allure-results/");
    File logs = new File("test-outputs/Logs/");
    File screenshotPath = new File("test-outputs/Screenshots");


    public void onExecutionStart() {
        LogUtil.info("Execution started");

        readDataFromPropertyFile.loadPropertiesFiles();
        LogUtil.info("Properties file loaded");

        FileUtils.deletePreviousFiles(allureResults);
        LogUtil.info("Previous files deleted from allure results");

        FileUtils.cleanDirectory(logs);
        LogUtil.info("Previous logs deleted");

        FileUtils.cleanDirectory(screenshotPath);
        LogUtil.info("Previous screenshots deleted");

    }

    @Override
    public void onExecutionFinish() {

        LogUtil.info("Execution finished");

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            switch (testResult.getStatus()) {
                case ITestResult.SUCCESS -> UtilClass.takeScreenshot("passed - " + testResult.getName());
                case ITestResult.FAILURE -> UtilClass.takeScreenshot("failed - " + testResult.getName());
                case ITestResult.SKIP -> UtilClass.takeScreenshot("skipped - " + testResult.getName());
            }
            AllureUtil.addLogsToAllureReport();
        }
    }


    @Override
    public void onTestStart(ITestResult result) {
        LogUtil.info("Test Case ," + result.getName() + " started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtil.info("Test Case ," + result.getName() + " success");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtil.error("Test Case ," + result.getName() + " Failed");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtil.warn("Test Case ," + result.getName() + " Skipped");
    }

    @Override
    public void onStart(ITestContext context) {
        LogUtil.info("Execution started");
    }

    @Override
    public void onFinish(ITestContext context) {
        LogUtil.info("Execution finished");
    }


}
