package com.sparta.upgradeschedule.controller;

import com.sparta.upgradeschedule.dto.ParticipantRequestDto;
import com.sparta.upgradeschedule.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ParticipantController {

    private final ParticipantService participantService;

    // 참가자 추가
    @PostMapping("/participants")
    public void addParticipant(@RequestBody ParticipantRequestDto requestDto) {
        participantService.addParticipant(requestDto);
    }



}
