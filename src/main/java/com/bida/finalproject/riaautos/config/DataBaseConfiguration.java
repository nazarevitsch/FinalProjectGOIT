package com.bida.finalproject.riaautos.config;

import com.bida.finalproject.riaautos.domain.Color;
import com.bida.finalproject.riaautos.domain.Mark;
import com.bida.finalproject.riaautos.domain.Model;
import com.bida.finalproject.riaautos.domain.Region;
import com.bida.finalproject.riaautos.request.JSONParser;
import com.bida.finalproject.riaautos.request.Request;
import com.bida.finalproject.riaautos.service.ColorService;
import com.bida.finalproject.riaautos.service.ModelService;
import com.bida.finalproject.riaautos.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DataBaseConfiguration {

    @Autowired
    private ModelService modelService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private RegionService regionService;

    @PostConstruct
    public void createModelsTable(){
        Request request = new Request();
        Mark[] marks = Mark.values();
        for (int i = 0; i < marks.length; i++) {
            System.out.println(marks[i].getName());
            try {
                String json = request.getAllModelsByCategoryAndByModel(1, marks[i].getValue());
                Model[] models = JSONParser.parseModels(json);
                for (int l = 0; l < models.length; l++){
                    models[l].setMarkID(marks[i].getValue());
                    System.out.println(models[l]);
                }
                // Does not work !!!
                List<Model> modelsList = Arrays.asList(models);
                System.out.println(2222222);
                System.out.println(modelService);
                modelService.saveModels(modelsList);
            } catch (Exception e) {
                System.out.println("ERROR...");
            }
        }
    }

    public void createColorsTable(){
        Request request = new Request();
        try {
            String json = request.getAllColors();
            System.out.println(json);
            Color[] colors = JSONParser.parseColors(json);
            for (int i = 0; i < colors.length; i++) {
                System.out.println(colors[i]);
            }
        } catch (Exception e){
            System.out.println("ERROR...");
        }
    }

    public void createRegionTable(){
        Request request = new Request();
        try {
            String json = request.getAllRegions();
            System.out.println(json);
            Region[] regions = JSONParser.parseRegions(json);
            for (int i = 0; i < regions.length; i++) {
                System.out.println(regions[i]);
            }
        } catch (Exception e){
            System.out.println("ERROR...");
        }
    }
}

