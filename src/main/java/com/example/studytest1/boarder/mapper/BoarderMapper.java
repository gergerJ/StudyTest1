package com.example.studytest1.boarder.mapper;

import com.example.studytest1.dto.HYTestDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoarderMapper {


    @Select("SELECT * FROM HYTEST")
    List<HYTestDto> findAll();

    @Insert("INSERT INTO HYTEST(name, addr, phonenumber, lastorder) values(#{name}, #{addr}, #{phonenumber}, now())")
    int create(String name, String addr, String phonenumber);

    @Delete("DELETE FROM HYTEST where SEQ = ${seq}")
    int Delete(int seq);

}
