package com.sparta.upgradeschedule.dto;
import com.sparta.upgradeschedule.entity.Participant;
import com.sparta.upgradeschedule.entity.Schedule;
import com.sparta.upgradeschedule.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class IndividualScheduleResponseDto {
    private Long creatorId;
    private String creatorUsername;
    private String creatorUserEmail;
    private String title;
    private String content;
    private String createdDate;
    private String modifiedDate;
    private int numberOfComments;
    private int numberOfParticipants;
    private List<UserAsParticipantDto> participants = new ArrayList<>();

    // constructor used for individual searches
    public IndividualScheduleResponseDto(Schedule schedule, User user) {
        this.creatorId = schedule.getUserId();
        this.creatorUsername = user.getUsername();
        this.creatorUserEmail = user.getEmail();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.createdDate = String.valueOf(schedule.getCreatedDate());
        this.modifiedDate = String.valueOf(schedule.getModifiedDate());
        this.numberOfComments = schedule.getCommentList().size();
        this.numberOfParticipants = schedule.getParticipantList().size();

        // convert the list of participants to a list of users
        for (Participant participant : schedule.getParticipantList()) {
            User userFromParticipant = participant.getUser();
            UserAsParticipantDto dto = new UserAsParticipantDto(
                    userFromParticipant.getId(),
                    userFromParticipant.getUsername(),
                    userFromParticipant.getEmail());
            participants.add(dto);
        }
    }
}
