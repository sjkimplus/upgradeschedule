package com.sparta.upgradeschedule.controller;
import com.sparta.upgradeschedule.dto.GeneralScheduleResponseDto;
import com.sparta.upgradeschedule.dto.ScheduleRequestDto;
import com.sparta.upgradeschedule.dto.IndividualScheduleResponseDto;
import com.sparta.upgradeschedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 저장
    @PostMapping("/schedules")
    public void createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        scheduleService.createSchedule(requestDto);
    }

    // 수정
    @PutMapping("/schedules/{id}")
    public void updateSchedule(@PathVariable("id") long id, @RequestBody ScheduleRequestDto requestDto) {
        scheduleService.updateSchedule(id, requestDto);
    }

    // 조회
    @GetMapping("/schedules/{id}")
    public IndividualScheduleResponseDto getSchedule(@PathVariable("id") long id) {
        return scheduleService.getSchedule(id);
    }

    // 페이징/정렬
    @GetMapping("/schedules")
    public Page<GeneralScheduleResponseDto> getSchedules(
            @RequestParam("page") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return scheduleService.getSchedules(page-1, size);
    }

    // 삭제
    @DeleteMapping("/schedules/{id}")
    public void deleteSchedule(@PathVariable("id") long id) {
        scheduleService.deleteSchedule(id);
    }
}
