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
            autos.add(JSONParser.parseAndFindAuto(request.searchAutoByID(links.get(i))));
        }
        return autos;
    }

    public String createTextForEmailFromAutos(List<Auto> autos){
        String line = "";
        for (int i = 0; i < autos.size(); i++){

            line = line + String.format("Title: %s, Price: %d, Phone: %s, Location: %s, Link: %s \n", autos.get(i).getTitle(),
                    autos.get(i).getPrice(), autos.get(i).getPhone(), autos.get(i).getLocationCityName(), autos.get(i).getLinkToView());


//            line = line + "Title: " + autos.get(i).getTitle() + ", Price: " + autos.get(i).getPrice() + ", Phone: " + autos.get(i).getPhone() +
//                     ", Location: " + autos.get(i).getLocationCityName() + ", Link: " + autos.get(i).getLinkToView() + "\n";
        }
        return line;
    }
}
