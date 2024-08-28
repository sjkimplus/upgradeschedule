package com.sparta.upgradeschedule.service;

import com.sparta.upgradeschedule.dto.ParticipantRequestDto;
import com.sparta.upgradeschedule.entity.Participant;
import com.sparta.upgradeschedule.entity.Schedule;
import com.sparta.upgradeschedule.entity.User;
import com.sparta.upgradeschedule.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ParticipantService {

    private final ParticipantRepository participantRepository;
    private final ScheduleService scheduleService;
    private final UserService userService;

    public void addParticipant(ParticipantRequestDto requestDto) {
        Schedule schedule = scheduleService.returnSchedule(requestDto.getScheduleId());
        User user = userService.returnUser(requestDto.getUserId());
        Participant participant = new Participant(schedule, user);
        participantRepository.save(participant);
    }
}
