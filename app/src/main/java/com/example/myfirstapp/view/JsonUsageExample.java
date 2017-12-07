/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author NathanG
 */
public class JsonUsageExample {
    
    public JsonUsageExample(){
        JSONParser parser = new JSONParser();
        try{
//        String tempDir = System.getProperty("user.dir");
//        System.out.println(tempDir);
//        To use local directory online suggestions suggest using getResourceAs Stream().  Will try more another time.
                

        JSONObject jsonObj = (JSONObject) parser.parse(new FileReader("G:\\githubRepo\\MVC_Base\\src\\view\\SampleJsonFile.json"));
        System.out.println("jsonObj contains.");
        System.out.println(jsonObj);
        String tempElement = (String) jsonObj.get("Element");
        String tempWeakness = (String) jsonObj.get("Weakness");
        if (tempElement.equals("Electric")){
            jsonObj.put("Element", "Legendary");
            jsonObj.put("Weakness", "None");
        } else {
            jsonObj.put("Element", "Electric");
            jsonObj.put("Weakness", "Earth");
        }
        System.out.println("jsonObj has been updated.  It contains.");
        System.out.println(jsonObj);
        try{
            FileWriter file = new FileWriter("G:\\githubRepo\\MVC_Base\\src\\view\\SampleJsonFile.json");
            file.write(jsonObj.toJSONString());
            file.flush();
            file.close();
            System.out.println("The Json file has been updated.");
        } catch (IOException e){}
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {
        }
    }
    
    
    
}
