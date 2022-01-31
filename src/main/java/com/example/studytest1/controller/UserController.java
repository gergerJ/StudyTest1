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

    @PostMapping (value = "/createUser")
    public ModelAndView createUser(ModelAndView mv, String id, String passwd){
        mv.addObject("create", userService.createUser(id,passwd));
        mv.setViewName("result.html");
        return mv;
    }

}
