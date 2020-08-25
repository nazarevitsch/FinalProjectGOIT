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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

@Configuration
public class DataBaseConfiguration {

    @Autowired
    private ModelService modelService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private RegionService regionService;

    Logger logger = LoggerFactory.getLogger(DataBaseConfiguration.class);

    @PostConstruct
    public void createAndUpdateTables() {
        createModelsTable();
        createColorsTable();
        createRegionTable();
        logger.info("Data Base is already UPDATED!");
    }

    public void createModelsTable() {
        List<Model> modelsAlreadyExisted = modelService.findAll();
        Request request = new Request();
        Mark[] marks = Mark.values();
        for (int i = 0; i < marks.length; i++) {
            try {
                String json = request.getAllModelsByCategoryAndByModel(1, marks[i].getValue());
                Model[] models = JSONParser.parseModels(json);
                List<Model> modelsList = new ArrayList<>();
                for (int l = 0; l < models.length; l++) {
                    models[l].setMarkID(marks[i].getValue());
                    modelsList.add(models[l]);
                }
                modelsList.removeAll(modelsAlreadyExisted);
                modelService.saveModels(modelsList);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ERROR MODELS...");
            }
        }
    }

    public void createColorsTable() {
        List<Color> colorsAlreadyExisted = colorService.findAll();
        Request request = new Request();
        try {
            String json = request.getAllColors();
            Color[] colors = JSONParser.parseColors(json);
            List<Color> colorsList = new ArrayList<>();
            for (int i = 0; i < colors.length; i++){
                colorsList.add(colors[i]);
            }
            colorsList.removeAll(colorsAlreadyExisted);
            colorService.saveColors(colorsList);
        } catch (Exception e) {
            System.out.println("ERROR COLORS...");
        }
    }

    public void createRegionTable() {
        List<Region> regionsAlreadyExisted = regionService.findAll();
        Request request = new Request();
        try {
            String json = request.getAllRegions();
            Region[] regions = JSONParser.parseRegions(json);
            List<Region> regionList = new ArrayList<>();
            for(int i = 0; i < regions.length; i++){
                regionList.add(regions[i]);
            }
            regionList.removeAll(regionsAlreadyExisted);
            regionService.saveRegions(regionList);
        } catch (Exception e) {
            System.out.println("ERROR REGION...");
        }
    }
}