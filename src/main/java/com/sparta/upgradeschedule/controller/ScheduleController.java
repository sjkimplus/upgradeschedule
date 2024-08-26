package com.sparta.upgradeschedule.controller;
import com.sparta.upgradeschedule.dto.ScheduleRequestDto;
import com.sparta.upgradeschedule.dto.ScheduleResponseDto;
import com.sparta.upgradeschedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 저장
    @PostMapping("/schedule")
    public void createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        scheduleService.createSchedule(requestDto);
    }

    // 수정
    @PutMapping("/schedule/{id}")
    public void updateSchedule(@PathVariable("id") long id, @RequestBody ScheduleRequestDto requestDto) {
        scheduleService.updateSchedule(id, requestDto);
    }

    // 조회
    @GetMapping("/schedule/{id}")
    public ScheduleResponseDto getSchedule(@PathVariable("id") long id) {
        return scheduleService.getSchedule(id);
    }


}
