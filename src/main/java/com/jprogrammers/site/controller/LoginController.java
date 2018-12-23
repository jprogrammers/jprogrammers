package com.jprogrammers.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "login")
public class LoginController {

    @GetMapping("")
    public String getLogin(){
        return "login";
    }
}
