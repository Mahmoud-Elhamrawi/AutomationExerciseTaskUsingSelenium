package com.TestV3.Utils.LogUtils;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {

    public static final String logPath = "test-outputs/Logs/";


    //get logger
    public static Logger getLogger() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());

    }

    //set logger
    public static void info(String ... msg) {
        getLogger().info(String.join(" ", msg));
    }


    public static void error(String ... msg) {
        getLogger().error(String.join(" ", msg));
    }

    public static void warn(String ... msg) {
        getLogger().warn(String.join(" ", msg));
    }

    public static void debug(String ... msg) {
        getLogger().debug(String.join(" ", msg));
    }






}
