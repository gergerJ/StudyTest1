package com.example.studytest1.boarder.controller;


import com.example.demo.boarder.service.BoarderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BoarderController {
    private final BoarderService boarderService;

    @GetMapping(value = "/indexTable")
    public ModelAndView findALl(ModelAndView mv){
        mv.setViewName("TableResult01.html");
        return mv;
    }

}
