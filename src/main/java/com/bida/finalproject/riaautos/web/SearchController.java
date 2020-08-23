package com.bida.finalproject.riaautos.web;

import com.bida.finalproject.riaautos.domain.*;
import com.bida.finalproject.riaautos.request.JSONParser;
import com.bida.finalproject.riaautos.request.Request;
import com.bida.finalproject.riaautos.service.ColorService;
import com.bida.finalproject.riaautos.service.RegionService;
import com.bida.finalproject.riaautos.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.security.Principal;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private RegionService regionService;

    @Autowired
    private ColorService colorService;

    @Autowired
    SearchService searchService;

    @GetMapping("/search")
    public String search(Model model){
        model.addAttribute("bodyStyles", BodyStyle.values());
        model.addAttribute("marks", Mark.values());
        model.addAttribute("gearBoxes", GearBox.values());
        model.addAttribute("fuelTypes", FuelType.values());
        model.addAttribute("regions", regionService.findAll());
        model.addAttribute("colors", colorService.findAll());
        return "search";
    }

    @PostMapping("/search_query")
    public String searchQuery(@ModelAttribute(name = "search")Search search, Principal principal){
        search.setUsername(principal.getName());
        searchService.save(search);
        Request request = new Request();
        String answer = request.searchRequest(search.getCategoryID(), search.getBodyStyleID(), search.getMarkID(), search.getModelID(), search.getRegionID(),
                search.getColorID(), search.getGearBoxID(), search.getFuelTypeID(), search.getPriceFrom(), search.getPriceTo(),0);
        int count = JSONParser.parseAndFindCount(answer);
        count = count % 10 > 0 ? (count / 10) + 1 : (count / 10);
        System.out.println(count);
        List<String> list = JSONParser.parseSearchResult(answer);
        System.out.println(list);
        for (int i = 1; i < count; i++){
            System.out.println("I: " + i);
            answer = request.searchRequest(search.getCategoryID(), search.getBodyStyleID(), search.getMarkID(), search.getModelID(), search.getRegionID(),
                    search.getColorID(), search.getGearBoxID(), search.getFuelTypeID(), search.getPriceFrom(), search.getPriceTo(), i);
            List<String> current = JSONParser.parseSearchResult(answer);
            System.out.println(current);
            for (int l = 0; l < current.size(); l++){
                System.out.println(current.get(l));
                list.add(current.get(l));
            }
        }
        System.out.println(list);
        return "results";
    }
}
