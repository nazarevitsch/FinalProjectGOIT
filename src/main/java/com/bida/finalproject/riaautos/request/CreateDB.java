package com.bida.finalproject.riaautos.request;

import com.bida.finalproject.riaautos.domain.Mark;
import com.bida.finalproject.riaautos.domain.Model;
import com.bida.finalproject.riaautos.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CreateDB {

    @Autowired
    private ModelService modelService;

    public void createModelsTable(){
        Request request = new Request();
        String json = request.getAllModelsByCategoryAndByModel(1, Mark.AUDI.getValue());
        Model[] models = (Model[]) JSONParser.parseModels(json);
        List<Model> modelsList = Arrays.asList(models);
        modelService.saveModel(modelsList.get(1));
    }
}
