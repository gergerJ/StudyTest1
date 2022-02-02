package com.example.studytest1.boarder.service;

import com.example.studytest1.boarder.mapper.BoarderMapper;
import com.example.studytest1.dto.HYTestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoarderService {
    private final BoarderMapper boarderMapper;

    public List<HYTestDto> findAll(){
        return boarderMapper.findAll();
    }
    public int createUser(HYTestDto hyTestDto){
        log.info("name:{}",hyTestDto.getName());
        return boarderMapper.create(hyTestDto.getName(), hyTestDto.getAddr(), hyTestDto.getPhonenumber() );
    }

    public int DeleteUser(HYTestDto hyTestDto){
        log.info("seq:{}",hyTestDto.getSeq());
        return boarderMapper.Delete(hyTestDto.getName(), hyTestDto.getAddr(), hyTestDto.getPhonenumber() );
    }

}
