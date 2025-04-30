package com.TestV3.Utils.DataUtils;

import com.TestV3.Utils.LogUtils.LogUtil;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class readDataJsonFile {


    public static final String jsonFilePath = "src/test/resources/";
     String jsonReader = "";
    String jsonFileName="";

    // define json file  as String in default Constructor
    public readDataJsonFile(String jsonFileName)
    {
        this.jsonFileName = jsonFileName;

        try {
            JSONObject JObj = (JSONObject) new JSONParser().parse(new FileReader(jsonFilePath + jsonFileName+".json"));
            jsonReader = JObj.toJSONString();
        } catch (Exception e) {
            LogUtil.error("Json file not found" + e.getMessage());
        }
    }

    //get json key value
    public  String getJsonKeyValue(String key) {
        String testData ="" ;
        try{
            testData = JsonPath.read(jsonReader, key);

        }catch (Exception e) {
            LogUtil.error("Json file not found" + e.getMessage());
        }
        return testData;

    }









}
