package com.example.studytest1.boarder.controller;


import com.example.studytest1.boarder.service.BoarderService;
import com.example.studytest1.dto.HYTestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BoarderController {
    private final BoarderService boarderService;

    @GetMapping(value = "/indexTable1")
    public ModelAndView findALl(ModelAndView mv){
        mv.addObject("findAll", boarderService.findAll());
        mv.setViewName("boarder/boarderList.html");
        return mv;
    }
    @GetMapping(value ="/createButton")
    public ModelAndView createButton(ModelAndView mv){
        mv.setViewName("boarder/boarderRegister.html");
        return mv;
    }
    @PostMapping(value ="/createUser")
    public ModelAndView createUser(ModelAndView mv, HYTestDto hyTestDto){

        int result = boarderService.createUser(hyTestDto);
        log.info("회원등록 완료!  {}", result);

        mv.addObject("findAll", boarderService.findAll());
        mv.setViewName("boarder/boarderList.html");
        return mv;
    }
    @PostMapping(value ="/DeleteHYUser")
    public ModelAndView DeleteUser(ModelAndView mv, HYTestDto hyTestDto){

        int result = boarderService.DeleteUser(hyTestDto);
        log.info("회원등록 완료!  {}", result);

        mv.addObject("findAll", boarderService.findAll());
        mv.setViewName("boarder/boarderList.html");
        return mv;
    }


}
