package com.example.demo;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController {
    @GetMapping("/note")
    public ModelAndView note(){
        String author = "Unknown Author";
        ModelAndView mv = new ModelAndView();
        mv.setViewName("note");
        mv.addObject("author", author);
        return mv;
    }
    public String fun(){
        WebMvcAutoConfiguration a = new WebMvcAutoConfiguration();
        System.out.println(a);
        return "fun";
    }
}
