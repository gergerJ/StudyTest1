package com.example.studytest1.boarder.mapper;

import com.example.studytest1.dto.HYTestDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoarderMapper {


    @Select("SELECT * FROM HYTEST")
    List<HYTestDto> findAll();

    @Insert("INSERT INTO HYTEST(name, addr, phonenumber, lastorder) values(#{name}, #{addr}, #{phonenumber}, now())")
    int create(HYTestDto hyTestDto);

    @Delete("DELETE FROM HYTEST where SEQ = #{seq}")
    int Delete(long seq);

    @Update("UPDATE HYTEST SET name = #{name}, addr = #{addr}, phonenumber = #{phonenumber} where seq = #{seq}")
    int update(HYTestDto hyTestDto);

//    @Select("SELECT * FROM HYTEST WHERE SEQ=#{seq}")
//    HYTestDto UpdateListSelect(String name, String addr, String phonenumber, int seq);
    @Select("SELECT * FROM HYTEST WHERE SEQ=#{seq}")
    HYTestDto UpdateListSelect(long seq);
}
