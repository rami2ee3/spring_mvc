package org.rami.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


    @GetMapping("/")
    public String loginPage() throws Exception {
        return "login";
    }

    @GetMapping("/join")
    public String joinPage() throws Exception{
        return "join";
    }



}
