package com.bida.finalproject.riaautos.service;

import com.bida.finalproject.riaautos.domain.*;
import com.bida.finalproject.riaautos.repository.SearchRepository;
import com.bida.finalproject.riaautos.repository.SearchVersionForWEBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    @Autowired
    private SearchVersionForWEBRepository searchVersionForWEBRepository;

    public void save(Search search){
        searchRepository.save(search);
    }

    public List<SearchVersionForWEB> findAllByUsername(String username){
        List<SearchVersionForWEB> list =  searchVersionForWEBRepository.findAllByUsername(username);
        for(int i = 0; i < list.size(); i++) {
            list.get(i).setCategoryName("Легковая");
            list.get(i).setFuelTypeName(FuelType.getNameByValue(list.get(i).getFuelTypeID()));
            list.get(i).setGearBoxName(GearBox.getNameByValue(list.get(i).getGearBoxID()));
            list.get(i).setMarkName(Mark.getNameByValue(list.get(i).getMarkID()));
            list.get(i).setBodyStyleName(BodyStyle.getNameByValue(list.get(i).getBodyStyleID()));
        }
        return list;
    }
}
