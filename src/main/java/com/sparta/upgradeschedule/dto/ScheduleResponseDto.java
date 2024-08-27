package com.sparta.upgradeschedule.dto;
import com.sparta.upgradeschedule.entity.Comment;
import com.sparta.upgradeschedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleResponseDto {
    private String user;
    private String title;
    private String content;
    private String createdDate;
    private String modifiedDate;
    private int numberOfComments;

    public ScheduleResponseDto(Schedule schedule) {
        this.user = schedule.getUser();
        this.title = schedule.getContent();
        this.content = schedule.getContent();
        this.createdDate = String.valueOf(schedule.getCreatedDate());
        this.modifiedDate = String.valueOf(schedule.getModifiedDate());
        this.numberOfComments = schedule.getCommentList().size();
    }
}
