package com.bida.finalproject.riaautos.web;

import com.bida.finalproject.riaautos.domain.BodyStyle;
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
        return "search";
    }
}
