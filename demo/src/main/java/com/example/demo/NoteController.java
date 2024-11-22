package com.example.demo;

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
}
