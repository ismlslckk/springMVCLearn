package com.ismlslck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/403")
    public String error403(){
        return "403";
    }
}
