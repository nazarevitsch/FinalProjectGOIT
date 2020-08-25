package com.bida.finalproject.riaautos.web;

import com.bida.finalproject.riaautos.domain.*;
import com.bida.finalproject.riaautos.request.JSONParser;
import com.bida.finalproject.riaautos.request.Request;
import com.bida.finalproject.riaautos.service.AutoService;
import com.bida.finalproject.riaautos.service.ColorService;
import com.bida.finalproject.riaautos.service.RegionService;
import com.bida.finalproject.riaautos.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private RegionService regionService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private AutoService autoService;

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
    public String searchQuery(@ModelAttribute(name = "search")Search search, Principal principal, Model model, @RequestBody String str){
        search.setUsername(principal.getName());
        searchService.save(search);
        Request request = new Request();
        String answer = request.searchRequest(search, 0);
        int count = JSONParser.parseAndFindCount(answer);
        count = count % 10 > 0 ? (count / 10) + 1 : (count / 10);
        List<String> list = JSONParser.parseSearchResult(answer);
        model.addAttribute("link", "\"" + request.generateURI(search, -1) + "\"");
        model.addAttribute("pages", count);
        model.addAttribute("currentPage", 1);
        model.addAttribute("autos", autoService.createAutosFromLinks(list));
        return "results";
    }

    @GetMapping("/page")
    public String page(@RequestHeader("link") String link, @RequestHeader("page") int page, @RequestHeader("pages") int pages, Model model){
        Request request = new Request();
        model.addAttribute("link", "\"" + link + "\"");
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page + 1);
        model.addAttribute("autos", autoService.createAutosFromLinks(JSONParser.parseSearchResult(request.searchRequest(link, page))));
        return "results";
    }

    @GetMapping("/searches_history")
    public String findAllSearch(Model model, Principal principal){
        model.addAttribute("searches", searchService.findAllByUsername(principal.getName()));
        return "searches-history";
    }

}
