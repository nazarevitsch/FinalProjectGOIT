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
        FuelType[] fuelTypes = FuelType.values();
        GearBox[] gearBoxes = GearBox.values();
        Mark[] marks = Mark.values();
        BodyStyle[] bodyStyles = BodyStyle.values();
        for(int i = 0; i < list.size(); i++) {
            list.get(i).setCategoryName("Легковая");
            for (int l = 0; l < fuelTypes.length; l++) {
                if (fuelTypes[l].getValue() == list.get(i).getFuelTypeID()){
                    list.get(i).setFuelTypeName(fuelTypes[l].getName());
                    break;
                }
            }
            for (int l = 0; l < gearBoxes.length; l++){
                if (gearBoxes[l].getValue() == list.get(i).getGearBoxID()){
                    list.get(i).setGearBoxName(gearBoxes[l].getName());
                    break;
                }
            }
            for (int l = 0; l < marks.length; l++){
                if (marks[l].getValue() == list.get(i).getMarkID()){
                    list.get(i).setMarkName(marks[l].getName());
                    break;
                }
            }
            for (int l = 0; l < bodyStyles.length; l++){
                if (bodyStyles[l].getValue() == list.get(i).getBodyStyleID()){
                    list.get(i).setBodyStyleName(bodyStyles[l].getName());
                    break;
                }
            }
        }
        System.out.println(list);
        return list;
    }
}
