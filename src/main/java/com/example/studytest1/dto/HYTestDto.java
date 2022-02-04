package com.example.studytest1.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HYTestDto {
    private Long seq;
    private String name;
    private String addr;
    private String phonenumber;
    private LocalDate lastorder;

}
