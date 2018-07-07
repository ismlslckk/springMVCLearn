package com.ismlslck.controller;

import com.ismlslck.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String loginForm(Model model){
        model.addAttribute("user",new User());
        return "login";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String login(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model){
        return "login";
    }


}
