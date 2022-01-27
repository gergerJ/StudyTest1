package com.example.studytest1.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserBoardDto {
    private Long seq;
    private String email;
    private String passwd;
    private int login_count;
    private LocalDateTime last_login_at;
    private LocalDateTime create_at;
}
