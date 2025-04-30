package com.TestV3.Utils.AllureUtil;

import com.TestV3.Utils.FileUtil.FileUtils;
import com.TestV3.Utils.LogUtils.LogUtil;
import io.qameta.allure.Allure;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllureUtil {

    // add logs to allure report
    public static void addLogsToAllureReport() {
        try {
            File lastLog = FileUtils.getLastLogFile(LogUtil.logPath);
            Allure.addAttachment("Logs.log", Files.readString(Path.of(lastLog.getPath())));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }




    // add screenshot to allure report
    public static void addScreenshotToAllureReport(String screenshotName, String screenshotPath) {
        try {
            Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenshotPath)));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
