package com.bida.finalproject.riaautos.request;

import com.bida.finalproject.riaautos.domain.Color;
import com.bida.finalproject.riaautos.domain.Model;
import com.bida.finalproject.riaautos.domain.Region;
import com.bida.finalproject.riaautos.domain.SearchResult;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class JSONParser {

    public static Model[] parseModels(String json){
        Gson gson = new Gson();
        Model[] models = gson.fromJson(json, Model[].class);
        return models;
    }

    public static Color[] parseColors(String json) {
        Gson gson = new Gson();
        Color[] colors = gson.fromJson(json, Color[].class);
        return colors;
    }

    public static Region[] parseRegions(String json) {
        Gson gson = new Gson();
        Region[] regions = gson.fromJson(json, Region[].class);
        return regions;
    }

    public static List<String> parseSearchResult(String json){
        String line =json.substring(json.indexOf("search_result\":{\"ids\":") + 23);
        line = line.substring(0, line.indexOf("]"));
        List<String> list = Arrays.asList(line.replaceAll("\"", "").split(","));
        return list;
    }

    public static int parseAndFindCount(String json){
        String line = json.substring(json.indexOf("\"count\":") + 8);
        int a = Integer.valueOf(line.substring(0, line.indexOf(",")));
        return a;
    }
}
