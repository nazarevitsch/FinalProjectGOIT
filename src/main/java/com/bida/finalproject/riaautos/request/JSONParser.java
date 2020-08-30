package com.bida.finalproject.riaautos.request;

import com.bida.finalproject.riaautos.domain.*;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class JSONParser {

    public static Model[] parseModels(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Model[].class);
    }

    public static Color[] parseColors(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Color[].class);
    }

    public static Region[] parseRegions(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Region[].class);
    }

    public static List<String> parseSearchResult(String json){
        String line =json.substring(json.indexOf("search_result\":{\"ids\":") + 23);
        line = line.substring(0, line.indexOf("]"));
        List<String> list = Arrays.asList(line.replaceAll("\"", "").split(","));
        List<String> result = new ArrayList();
        for (int i = 0; i < list.size(); i++){
            result.add(list.get(i));
        }
        return result;
    }

    public static int parseAndFindCount(String json){
        String line = json.substring(json.indexOf("\"count\":") + 8);
        int a = Integer.valueOf(line.substring(0, line.indexOf(",")));
        return a;
    }

    public static Auto parseAndFindAuto(String json){
        JSONObject jsonObject = new JSONObject(json);
        Auto auto = new Auto();
        try {
            auto.setLocationCityName(jsonObject.getString("locationCityName"));
            auto.setPhone(jsonObject.getJSONObject("userPhoneData").getString("phone"));
            auto.setPrice(jsonObject.getInt("USD"));
            auto.setLinkToView(jsonObject.getString("linkToView"));
            auto.setTitle(jsonObject.getString("title"));
            auto.setSeoLinkM(jsonObject.getJSONObject("photoData").getString("seoLinkM"));
        } catch (Exception e){
            log.error("Error with parsing Auto from Json: ", e.getMessage());
        }
        return auto;
    }
}
