package com.TestV3.Utils.DataUtils;

import com.TestV3.Utils.LogUtils.LogUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Properties;

public class readDataFromPropertyFile {

    public static final String propertiesFilePath = "src/main/resources/";

    //load data from properties files
    public static Properties loadPropertiesFiles() {

        try {

            Properties properties = new Properties();
            Collection<File> collectionFiles;
            collectionFiles = FileUtils.listFiles(new File(propertiesFilePath), new String[]{"properties"}, true);
            collectionFiles.forEach(file ->
                    {
            try {
                properties.load(new FileInputStream(file));
            } catch (Exception e) {
                LogUtil.error("Properties file not found" + e.getMessage());
            }
            properties.putAll(System.getProperties());
            System.setProperties(properties);
                    });
            return properties;
        } catch (Exception e) {
            LogUtil.error("Properties file not found" + e.getMessage());
            return null;
        }


    }




    // get data from properties file
    public static String getProperty(String key) {
        try {
            return System.getProperty(key);

        }catch (Exception e) {
            LogUtil.error("Properties file not found" + e.getMessage());
            return null;
        }
    }


}
