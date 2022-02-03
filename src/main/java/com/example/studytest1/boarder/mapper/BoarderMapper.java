package com.example.studytest1.boarder.mapper;

import com.example.studytest1.dto.HYTestDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoarderMapper {


    @Select("SELECT * FROM HYTEST")
    List<HYTestDto> findAll();

    @Insert("INSERT INTO HYTEST(name, addr, phonenumber, lastorder) values(#{name}, #{addr}, #{phonenumber}, now())")
    int create(String name, String addr, String phonenumber);

    @Delete("DELETE FROM HYTEST where SEQ = ${seq}")
    int Delete(int seq);

    @Update("UPDATE HYTEST SET NAME=#{name}, ADDR=#{addr}, PHONENUMBER=#{phonenumber} where SEQ = #{seq}")
    int Update(String name, String addr, String phonenumber, int seq);

//    @Select("SELECT * FROM HYTEST WHERE SEQ=#{seq}")
//    HYTestDto UpdateListSelect(String name, String addr, String phonenumber, int seq);
    @Select("SELECT * FROM HYTEST WHERE SEQ=#{seq}")
    HYTestDto UpdateListSelect(int seq);
}
