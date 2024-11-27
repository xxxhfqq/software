package com.example.demo;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class JsonController {
    @GetMapping("/json")
    @ResponseBody
    public Json json(){
        String path = System.getProperty("java.class.path");
        Json json = new Json(1,Date.valueOf("2020-02-02"),"Spring Boot","Author",path);
        return json;
    }
}
