package com.example.studytest1.boarder.controller;


import com.example.studytest1.boarder.service.BoarderService;
import com.example.studytest1.dto.HYTestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/boarder")
public class BoarderController {
    private final BoarderService boarderService;

    @GetMapping(value = "/list")
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
        mv.setViewName("redirect:/boarder/list");
        return mv;
    }
    @PostMapping(value ="/DeleteHYUser")
    public ModelAndView DeleteUser(ModelAndView mv, long seq){

        boarderService.DeleteUser(seq);
        log.info("회원삭제 완료! Controller ");

        mv.addObject("findAll", boarderService.findAll());
        mv.setViewName("boarder/boarderList.html");
        return mv;
    }
    // 업데이트 할 부분의 창 보여주기 부분 구현
    @GetMapping(value ="/UpdateHYUser")
    public ModelAndView UpdateListSelect(ModelAndView mv, long seq){

        log.info("회원수정 진행! Controller ");

        HYTestDto hyTestDto = boarderService.UpdateListSelect(seq);
        log.info("seq:{}, name:{} , addr:{}, phonenumber:{}",hyTestDto.getSeq(), hyTestDto.getName(), hyTestDto.getAddr(), hyTestDto.getPhonenumber());
        mv.addObject("user", hyTestDto);

        mv.setViewName("boarder/boarderUpdateList.html");
        return mv;
    }
    //실제 업데이트 부분 구현
    @PostMapping(value ="/UpdateHYUser11")
    public ModelAndView UpdateUser(ModelAndView mv, HYTestDto hyTestDto){

        //boarderService.UpdateUser(hyTestDto);
        log.info("실제 회원 수정!!! Controller ");
        log.info("name:{}",hyTestDto.getName());

        //mv.addObject("findAll", boarderService.findAll());
        mv.addObject("findAll", boarderService.UpdateHYUser(hyTestDto));
        mv.setViewName("redirect:/boarder/list");
        return mv;
    }
}
