package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class GeneralController {

    private static final Logger logger = LoggerFactory.getLogger(GeneralController.class);
    @RequestMapping("/")
    public String index(Model model){

        Map<String, String > map = new HashMap<>();

        map.put("name", "ppip");
        map.put("desc", "描述");
        model.addAttribute("user", map);
        model.addAttribute("testMessage", "FTLtest");

        return "index";
    }

    @RequestMapping("/home")
    public String home(Model model){
        logger.info("Rendering home page with testftl.ftl template");
        model.addAttribute("testMessage", "FTLtest");
        return "testftl";
    }
}
