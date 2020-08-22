package com.bida.finalproject.riaautos.web;

import com.bida.finalproject.riaautos.domain.User;
import com.bida.finalproject.riaautos.service.UserService;
import com.bida.finalproject.riaautos.service.dto.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDto() {
        return new UserRegistrationDTO();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDTO userDto,
                                      BindingResult result){
        User existing = userService.findByUsername(userDto.getUsername());
        if (existing != null){
            result.rejectValue("username", null, "There is already an account registered with that username");
        }
        if (result.hasErrors()){
            return "registration";
        }
        userService.save(userDto);
        return "redirect:/index";
    }
}
