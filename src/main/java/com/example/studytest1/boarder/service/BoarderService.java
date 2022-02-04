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
        return boarderMapper.create(hyTestDto);
    }

    public List<HYTestDto> DeleteUser(long seq){
        int Result = boarderMapper.Delete(seq);
        String resultSet = "회원 삭제 실패";

        if(Result>0){
            resultSet = "회원 삭제 성공";
        }
        log.info(resultSet);
        return boarderMapper.findAll();
    }
    public HYTestDto UpdateListSelect(long seq){
//        log.info("seq:{}",hyTestDto.getSeq());
//        log.info("name:{}",hyTestDto.getName());
//        log.info("addr:{}",hyTestDto.getAddr());

//        log.info("seq{}", hyTestDto);
        return boarderMapper.UpdateListSelect(seq);
    }
    public List<HYTestDto> UpdateHYUser(HYTestDto hyTestDto){
        int result = boarderMapper.update(hyTestDto);

        String UpdateResult = "회원 정보 수정 실패";

        if(result >0){
            UpdateResult =" 회원 정보 수정 성공!!!!";
        }
        log.info(UpdateResult);
        return boarderMapper.findAll();
    }

}
