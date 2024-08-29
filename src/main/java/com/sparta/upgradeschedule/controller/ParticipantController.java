package com.sparta.upgradeschedule.controller;

import com.sparta.upgradeschedule.dto.ParticipantRequestDto;
import com.sparta.upgradeschedule.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    // 참가자 삭제
    @DeleteMapping("/participants/{id}")
    public void deleteParticipant(@PathVariable("id") long id) {
        participantService.deleteParticipant(id);
    }



}
