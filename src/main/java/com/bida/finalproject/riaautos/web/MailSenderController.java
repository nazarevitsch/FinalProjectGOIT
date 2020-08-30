package com.bida.finalproject.riaautos.web;


import com.bida.finalproject.riaautos.domain.*;
import com.bida.finalproject.riaautos.mailsender.EmailServiceImpl;
import com.bida.finalproject.riaautos.service.ColorService;
import com.bida.finalproject.riaautos.service.RegionService;
import com.bida.finalproject.riaautos.service.SearchForEmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class MailSenderController {

    @Autowired
    private RegionService regionService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private SearchForEmailNotificationService searchForEmailNotificationService;

    @GetMapping("/email_notification")
    public String search(Model model, Principal principal){
        model.addAttribute("bodyStyles", BodyStyle.values());
        if (searchForEmailNotificationService.findByUsername(principal.getName()) != null){
            model.addAttribute("alreadyHasNotification", true);
        }
        else {
            model.addAttribute("alreadyHasNotification", false);
        }
        model.addAttribute("marks", Mark.values());
        model.addAttribute("gearBoxes", GearBox.values());
        model.addAttribute("fuelTypes", FuelType.values());
        model.addAttribute("regions", regionService.findAll());
        model.addAttribute("colors", colorService.findAll());
        return "email-notification";
    }

    @PostMapping("/send_mails_order")
    public String sendMailsOrder(@ModelAttribute(name = "search") Search search, Principal principal){
        search.setUsername(principal.getName());
        if (searchForEmailNotificationService.findByUsername(principal.getName()) != null){
            return "redirect:/email_notification";
        }
        searchForEmailNotificationService.save(search);
        return "redirect:/email_notification";
    }

    @DeleteMapping("/delete_email_notification_subscribing")
    public ResponseEntity deleteSubscribing(Principal principal){
        searchForEmailNotificationService.delete(principal.getName());
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
