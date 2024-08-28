package com.sparta.upgradeschedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAsParticipantDto {
    private Long id;
    private String name;
    private String email;
}
