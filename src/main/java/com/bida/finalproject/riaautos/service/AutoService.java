package com.bida.finalproject.riaautos.service;

import com.bida.finalproject.riaautos.domain.Auto;
import com.bida.finalproject.riaautos.request.JSONParser;
import com.bida.finalproject.riaautos.request.Request;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoService {

    public List<Auto> createAutosFromLinks(List<String> links){
        Request request = new Request();
        List<Auto> autos = new ArrayList<>();
        for (int i = 0; i < links.size(); i++) {
            System.out.println(i);
            autos.add(JSONParser.parseAndFindAuto(request.searchAutoByID(links.get(i))));
        }
        return autos;
    }
}
