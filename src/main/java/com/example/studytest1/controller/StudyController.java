package com.example.studytest1.controller;

import com.example.studytest1.dto.HYTestDto;
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

    @GetMapping(value = "/HY")
    public ModelAndView requestHY(ModelAndView mv){
        mv.setViewName("requestHY.html");
        return mv;
    }
    @GetMapping (value="/HYTuserAll")
    public ModelAndView findAll(ModelAndView mv){
        mv.addObject("userAll", studyTest1Service.userAll());
        mv.setViewName("HYT.html");
        return mv;
    }
    @GetMapping(value="/findHYUser")
    public ModelAndView findHYUser(ModelAndView mv, int seq){
        HYTestDto hyTestDto = studyTest1Service.findHYUser(seq);
       // log.info("seq{}","name{}", "phonename", ${hy});
        mv.addObject("seq", hyTestDto.getSeq());
        mv.addObject("name", hyTestDto.getName());
        mv.addObject("phonenumber", hyTestDto.getPhonenumber());
        mv.setViewName("tableHYUser.html");
        return mv;
    }
}
