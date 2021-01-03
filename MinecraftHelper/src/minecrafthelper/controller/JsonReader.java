package minecrafthelper.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
    JSONParser parser = new JSONParser();
    
    public void getJsonData(String sUrl){
        try {
            URL url = new URL(sUrl);
            URLConnection uc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String input;
            String i = "";
            while((input = in.readLine()) != null){
                i += input;
            }
            
            JSONArray arr = (JSONArray)parser.parse(i);
            arr.forEach(block -> {
                JSONObject obj = (JSONObject)block;
                System.out.println("ID:" + obj.get("type") + " name:" + obj.get("name"));
            });
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
