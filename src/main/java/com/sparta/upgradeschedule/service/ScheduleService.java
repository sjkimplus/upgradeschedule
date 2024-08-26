package com.sparta.upgradeschedule.service;
import com.sparta.upgradeschedule.dto.ScheduleRequestDto;
import com.sparta.upgradeschedule.dto.ScheduleResponseDto;
import com.sparta.upgradeschedule.entity.Schedule;
import com.sparta.upgradeschedule.repository.ScheduleRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto getSchedule(long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid schedule ID: " + id));

        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto();
        scheduleResponseDto.setUser(schedule.getUser());
        scheduleResponseDto.setTitle(schedule.getTitle());
        scheduleResponseDto.setContent(schedule.getContent());
        scheduleResponseDto.setCreatedDate(String.valueOf(schedule.getCreatedDate()));
        scheduleResponseDto.setModifiedDate(String.valueOf(schedule.getModifiedDate()));
        return scheduleResponseDto;
    }

    public void createSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule();
        schedule.setUser(requestDto.getUser());
        schedule.setTitle(requestDto.getTitle());
        schedule.setContent(requestDto.getContent());
        scheduleRepository.save(schedule);
    }

    public void updateSchedule(Long id, ScheduleRequestDto requestDto) {

        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid schedule ID: " + id));

        schedule.setTitle(requestDto.getTitle());
        schedule.setContent(requestDto.getContent());
        System.out.println("new title: "+ schedule.getTitle());
        System.out.println("new content: "+ schedule.getContent());
    }

}