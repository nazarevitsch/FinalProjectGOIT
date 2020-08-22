package com.bida.finalproject.riaautos.service;

import com.bida.finalproject.riaautos.domain.Region;
import com.bida.finalproject.riaautos.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public void saveRegions(List<Region> regions){
        regionRepository.saveAll(regions);
    }

    public List<Region> findAll(){
        return regionRepository.findAll();
    }
}
