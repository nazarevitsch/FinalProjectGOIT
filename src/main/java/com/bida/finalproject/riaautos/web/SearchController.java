package com.bida.finalproject.riaautos.web;

import com.bida.finalproject.riaautos.domain.BodyStyle;
import com.bida.finalproject.riaautos.domain.FuelType;
import com.bida.finalproject.riaautos.domain.GearBox;
import com.bida.finalproject.riaautos.domain.Mark;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {

    @GetMapping("/search")
    public String search(Model model){
        model.addAttribute("bodyStyles", BodyStyle.values());
        model.addAttribute("marks", Mark.values());
        model.addAttribute("gearBoxes", GearBox.values());
        model.addAttribute("fuelTypes", FuelType.values());
        return "search";
    }
}
