package com.bida.finalproject.riaautos.service;

import com.bida.finalproject.riaautos.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionService regionService;

    public void saveRegions(List<Region> regions){
        regionService.saveRegions(regions);
    }
}
