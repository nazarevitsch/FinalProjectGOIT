package com.bida.finalproject.riaautos.request;

import com.bida.finalproject.riaautos.domain.Color;
import com.bida.finalproject.riaautos.domain.Model;
import com.bida.finalproject.riaautos.domain.Region;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

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
}
