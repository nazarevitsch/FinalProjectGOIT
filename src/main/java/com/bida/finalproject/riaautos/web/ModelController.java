package com.bida.finalproject.riaautos.web;

import com.bida.finalproject.riaautos.domain.Model;
import com.bida.finalproject.riaautos.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ModelController {

    @Autowired
    private ModelService modelService;

    @GetMapping("/models")
    public ResponseEntity<List<Model>> getModels(@RequestParam(name = "markID") int markID){
        return ResponseEntity.ok(modelService.findAllByMarkID(markID));
    }
}
