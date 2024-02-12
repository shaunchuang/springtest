package com.example.controller;

import jakarta.servlet.http.HttpServletRequest;
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
    public String home(Model model, HttpServletRequest request){
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        logger.info("Rendering home page with testftl.ftl template");
        logger.info("從伺服器: {} 的端口 {} 渲染網頁", serverName, serverPort);
        model.addAttribute("testMessage", "FTLtest");
        return "testftl";
    }
}
