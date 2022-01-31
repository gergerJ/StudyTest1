package com.example.studytest1.controller;

import com.example.studytest1.dto.UserBoardDto;
import com.example.studytest1.service.StudyTest1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequiredArgsConstructor
public class StudyController {

    private final StudyTest1Service studyTest1Service;

    @GetMapping(value = "/")
    public ModelAndView requestSize(ModelAndView mv){
        mv.setViewName("request.html");
        return mv;
    }


    @GetMapping(value = "/findUser")
    public ModelAndView findUser(ModelAndView mv, Long seq){

        UserBoardDto userDto = studyTest1Service.findUser(seq);

        log.info("seq : {} , email : {}, passwd: {}, create_at {} ",
                userDto.getSeq(), userDto.getEmail(), userDto.getPasswd(), userDto.getCreate_at());

        mv.addObject("email", userDto.getEmail());
        mv.addObject("passwd", userDto.getPasswd());
        mv.addObject("create_at", userDto.getCreate_at());
        mv.setViewName("table1.html");
        return mv;
    }
}
