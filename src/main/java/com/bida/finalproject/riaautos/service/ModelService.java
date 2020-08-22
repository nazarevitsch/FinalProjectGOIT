package com.bida.finalproject.riaautos.service;

import com.bida.finalproject.riaautos.domain.Model;
import com.bida.finalproject.riaautos.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    public void saveModels(List<Model> models){
        modelRepository.saveAll(models);
    }

    public void saveModel(Model model){
        modelRepository.saveAndFlush(model);
    }
}
