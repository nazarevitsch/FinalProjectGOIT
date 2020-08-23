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
    public void createAndUpdateTables(){
//        createModelsTable();
//        createColorsTable();
//        createRegionTable();
    }

    public void createModelsTable(){
        List<Model> modelsAlreadyExisted = modelService.findAll();
        Request request = new Request();
        Mark[] marks = Mark.values();
        for (int i = 0; i < marks.length; i++) {
            try {
                String json = request.getAllModelsByCategoryAndByModel(1, marks[i].getValue());
                Model[] models = JSONParser.parseModels(json);
                for (int l = 0; l < models.length; l++){
                    models[l].setMarkID(marks[i].getValue());
                }
                List<Model> modelsList = Arrays.asList(models);
                if (!modelsAlreadyExisted.containsAll(modelsList)) {
                    modelService.saveModels(modelsList);
                }
            } catch (Exception e) {
                System.out.println("ERROR...");
            }
        }
    }

    public void createColorsTable(){
        List<Color> colorsAlreadyExisted = colorService.findAll();
        Request request = new Request();
        try {
            String json = request.getAllColors();
            Color[] colors = JSONParser.parseColors(json);
            List<Color> colorsList = Arrays.asList(colors);
            if (!colorsAlreadyExisted.containsAll(colorsList)){
                colorService.saveColors(colorsList);
            }
        } catch (Exception e){
            System.out.println("ERROR...");
        }
    }

    public void createRegionTable(){
        List<Region> regionsAlreadyExisted = regionService.findAll();
        Request request = new Request();
        try {
            String json = request.getAllRegions();
            Region[] regions = JSONParser.parseRegions(json);
            List<Region> regionList = Arrays.asList(regions);
            if (!regionsAlreadyExisted.containsAll(regionList)){
                regionService.saveRegions(regionList);
            }
        } catch (Exception e){
            System.out.println("ERROR...");
        }
    }
}

