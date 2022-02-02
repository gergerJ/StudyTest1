package com.example.studytest1.mapper;

import com.example.studytest1.dto.HYTestDto;
import com.example.studytest1.dto.RegisterDto;
import com.example.studytest1.dto.UserBoardDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//DAO 기능 => DB 직접적인 연결하여 컨트롤
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USERS")
    List<UserBoardDto> selectAll();

    @Select("select * from HYTest")
    List<HYTestDto> userAll();

    @Select("SELECT * FROM USERS where seq = #{seq}")
    UserBoardDto findById(Long seq);

    @Insert("INSERT INTO users(email, passwd, login_count, last_login_at, create_at) VALUES (#{email},#{passwd},0,now(),now())")
    int registerUser(RegisterDto registerDto);

    @Insert("INSERT INTO users(email, passwd, login_count, last_login_at, create_at) VALUES (#{id},#{passwd},0,now(),now())")
    int createUser(String id, String passwd);

    @Insert("insert into HYTest(name, addr, phonenumber, lastorder) values(#{name} , #{addr}, #{phonenumber}, now())")
    int createHYUser(String name, String addr, String phonenumber);

    @Select("SELECT * FROM HYTest where seq = #{seq}")
    HYTestDto findHYTUser(int seq);

}
