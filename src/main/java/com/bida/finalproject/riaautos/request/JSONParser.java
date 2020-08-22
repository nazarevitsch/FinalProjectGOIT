package com.bida.finalproject.riaautos.request;

import com.bida.finalproject.riaautos.domain.Model;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class JSONParser {

    public static Object[] parseModels(String json){
        Gson gson = new Gson();
        Model[] models = gson.fromJson(json, Model[].class);
        for (int i = 0; i < models.length; i++){
            System.out.println(i);
            System.out.println(models[i]);
        }
        return models;
    }
}
