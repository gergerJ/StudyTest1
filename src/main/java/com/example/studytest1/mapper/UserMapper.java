package com.example.studytest1.mapper;

import com.example.studytest1.dto.UserBoardDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USERS")
    List<UserMapper> findAll();

    @Select("SELECT * FROM USERS where seq = #{seq}")
    UserBoardDto findById(Long seq);


}
