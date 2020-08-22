package com.bida.finalproject.riaautos.service;

import com.bida.finalproject.riaautos.domain.Color;
import com.bida.finalproject.riaautos.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {

    @Autowired
    private ColorRepository colorRepository;

    public void saveColors(List<Color> colors){
        colorRepository.saveAll(colors);
    }

    public List<Color> findAll(){
        return colorRepository.findAll();
    }
}
