package com.sparta.upgradeschedule.dto;

import com.sparta.upgradeschedule.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class UserResponseDto {
    private String username;
    private String email;
    private int numberOfParticipation;
    private String createdDate;
    private String modifiedDate;

    public UserResponseDto(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.numberOfParticipation = user.getParticipatingList().size();
        this.createdDate = String.valueOf(user.getCreatedDate());
        this.modifiedDate = String.valueOf(user.getModifiedDate());
    }
}
