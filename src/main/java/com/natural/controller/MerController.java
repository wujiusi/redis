package com.natural.controller;

import com.natural.service.iface.MerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class MerController {
    @Autowired
    private MerService merService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}
