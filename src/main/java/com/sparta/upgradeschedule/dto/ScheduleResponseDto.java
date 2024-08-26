package com.sparta.upgradeschedule.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleResponseDto {
    private String user;
    private String title;
    private String content;
    private String createdDate;
    private String modifiedDate;
}
