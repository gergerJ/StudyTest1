package com.example.studytest1.controller;

import com.example.studytest1.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//    @RequiredArgsConstructor이 위 생성자 역할 대신함!!

    @PostMapping(value = "/createUser1")
    public ModelAndView createUser1(ModelAndView mv, String id2, String passwd2){
        mv.addObject("create", userService.createUser(id2,passwd2));
        mv.setViewName("result.html");
        return mv;
    }
    @GetMapping(value= "/findAll")
    public ModelAndView findAll(ModelAndView mv){
        mv.addObject("selectAll", userService.selectAll());
        mv.setViewName("resultAll.html");
        return mv;
    }

    @PostMapping(value="/createHYUser")
    public ModelAndView createHYUser(ModelAndView mv, String name, String addr, String phonenumber){
        mv.addObject("createHY", userService.createHYUser(name, addr, phonenumber));
        mv.setViewName("resultHY.html");
        return mv;
    }


}


