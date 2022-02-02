package com.example.studytest1.service;


import com.example.studytest1.dto.HYTestDto;
import com.example.studytest1.dto.UserBoardDto;
import com.example.studytest1.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service // 인터페이스 서비스 기능 부가
@Slf4j // lombok 기능 log.
@RequiredArgsConstructor
public class StudyTest1Service {

    private final SqlSessionFactory sqlSessionFactory;
    private final UserMapper userMapper;


    public UserBoardDto findUser(Long seq) {
        log.info("(1)");
        return userMapper.findById(seq);

    }
    public List<HYTestDto> userAll(){
        return userMapper.userAll();
    }
    public HYTestDto findHYUser(int seq){
        return userMapper.findHYTUser(seq);
    }

}
