package com.bida.finalproject.riaautos.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String root(@RequestHeader Map<String, String> headers) {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
