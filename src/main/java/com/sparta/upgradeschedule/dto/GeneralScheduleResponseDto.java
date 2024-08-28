package com.sparta.upgradeschedule.dto;

import com.sparta.upgradeschedule.entity.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GeneralScheduleResponseDto {
    private String title;
    private String content;
    private String createdDate;
    private String modifiedDate;
    private int numberOfComments;

    // constructor used for individual searches
    public GeneralScheduleResponseDto(Schedule schedule) {
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.createdDate = String.valueOf(schedule.getCreatedDate());
        this.modifiedDate = String.valueOf(schedule.getModifiedDate());
        this.numberOfComments = schedule.getCommentList().size();
    }
}
