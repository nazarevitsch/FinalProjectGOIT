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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Slf4j
@EnableScheduling
public class DataBaseConfiguration {

    @Autowired
    private ModelService modelService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private RegionService regionService;

    @PostConstruct
    public void createAndUpdateTables() {
        createModelsTable();
        createColorsTable();
        createRegionTable();
        log.info("Data Base is already UPDATED!");
    }

    public void createModelsTable() {
        List<Model> modelsAlreadyExisted = modelService.findAll();
        Request request = new Request();
        Mark[] marks = Mark.values();
        for (int i = 0; i < marks.length; i++) {
            try {
                String json = request.getAllModelsByCategoryAndByModel(1, marks[i].getValue());
                List<Model> modelsList = new ArrayList<>(Arrays.asList(JSONParser.parseModels(json)));
                for (int l = 0; l < modelsList.size(); l++) {
                    modelsList.get(l).setMarkID(marks[i].getValue());
                }
                modelsList.removeAll(modelsAlreadyExisted);
                modelService.saveModels(modelsList);
            } catch (Exception e) {
                log.error("ERROR with update Models: {}", e.getMessage());
            }
        }
    }

    public void createColorsTable() {
        List<Color> colorsAlreadyExisted = colorService.findAll();
        Request request = new Request();
        try {
            String json = request.getAllColors();
            List<Color> colorsList = new ArrayList<>(Arrays.asList(JSONParser.parseColors(json)));
            colorsList.removeAll(colorsAlreadyExisted);
            colorService.saveColors(colorsList);
        } catch (Exception e) {
            log.error("ERROR with update Colors: {}", e.getMessage());
        }
    }

    public void createRegionTable() {
        List<Region> regionsAlreadyExisted = regionService.findAll();
        Request request = new Request();
        try {
            String json = request.getAllRegions();
            List<Region> regionList = new ArrayList<>(Arrays.asList(JSONParser.parseRegions(json)));
            regionList.removeAll(regionsAlreadyExisted);
            regionService.saveRegions(regionList);
        } catch (Exception e) {
            log.error("ERROR with update Regions: {}", e.getMessage());
        }
    }
}