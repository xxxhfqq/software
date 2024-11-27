package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class TextController {
    @GetMapping("/text")
    public ModelAndView text(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("text");
        return mv;
    }
}
