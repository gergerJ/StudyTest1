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
//    private final HYTestDto hyTestDto;

    public List<HYTestDto> findAll(){
        return boarderMapper.findAll();
    }

    public int createUser(HYTestDto hyTestDto){
        log.info("name:{}",hyTestDto.getName());
        return boarderMapper.create(hyTestDto.getName(), hyTestDto.getAddr(), hyTestDto.getPhonenumber() );
    }

    public List<HYTestDto> DeleteUser(int seq){
        int Result = boarderMapper.Delete(seq);
        String resultSet = "회원 삭제 실패";

        if(Result>0){
            resultSet = "회원 삭제 성공";
        }
        log.info(resultSet);
        return boarderMapper.findAll();
    }
    public int UpdateUser(HYTestDto hyTestDto){
        //boarderMapper.Update(seq);
        log.info("name{}", hyTestDto.getName());
        return boarderMapper.Update(hyTestDto.getName(), hyTestDto.getAddr(), hyTestDto.getPhonenumber(),hyTestDto.getSeq());
    }
    public HYTestDto UpdateListSelect(int seq){
//        log.info("seq:{}",hyTestDto.getSeq());
//        log.info("name:{}",hyTestDto.getName());
//        log.info("addr:{}",hyTestDto.getAddr());

//        log.info("seq{}", hyTestDto);
        return boarderMapper.UpdateListSelect(seq);
    }

}
