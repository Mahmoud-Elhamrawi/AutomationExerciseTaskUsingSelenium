package com.TestV3.Utils.FileUtil;

import com.TestV3.Utils.LogUtils.LogUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;

public class FileUtils {

    // geo last log
    public static File getLastLogFile(String logsFolder) {
        File logsFolderFile = new File(logsFolder);
        if (!logsFolderFile.exists()) {
            LogUtil.error("files not exist" );
            return null;
        }

        File[] files = logsFolderFile.listFiles();
        assert files != null;

        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        return files[0];

    }


    // delete previousFiles from allure results
    public static void deletePreviousFiles(File previousFiles) {

        if (!previousFiles.exists()) {
             LogUtil.error("files not exist" );
             return;
        }

        File[] files = previousFiles.listFiles();
        assert files != null;

        for (File file : files) {
            if(file.isDirectory()) {
                deletePreviousFiles(file);

            }else {
                try {
                    Files.delete(file.toPath());
                } catch (IOException e) {
                   LogUtil.error("files not deleted" + e.getMessage());
                }
            }
        }

    }


    //Clean Directory
    public static void cleanDirectory (File folderPath) {
        try {
            org.apache.commons.io.FileUtils.cleanDirectory(folderPath);
        } catch (IOException e) {
            LogUtil.error("Failed to clean directory: " + e.getMessage());
        }


    }




}
