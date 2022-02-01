package com.example.studytest1.service;

import com.example.studytest1.dto.RegisterDto;
import com.example.studytest1.dto.UserBoardDto;
import com.example.studytest1.mapper.UserMapper;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;


    public String registerUser(RegisterDto registerDto){
        int result = userMapper.registerUser(registerDto);
        String registerResult = "실패";

        if(result > 0){
            registerResult = "회원 등록 성공";
            log.info("[ UserService 입력 성공]");
        }
        return registerResult;
    }
    public String createUser(String id, String passwd){
        int result = userMapper.createUser(id,passwd);
        String registerResult = "회원 등록 실패";

        if (result >0) {
            registerResult = "회원 등록 성공";
            log.info("등록 성공!");
        }
        return registerResult;
    }
    public String createHYUser(String name, String addr, String phonenumber){
        int result = userMapper.createHYUser(name, addr, phonenumber);
        String resultSet = "등록 실패";

        if(result>0){
            resultSet = "등록 성공";
        }
        return resultSet;
    }
    public List<UserBoardDto> selectAll(){return userMapper.selectAll();}
}
