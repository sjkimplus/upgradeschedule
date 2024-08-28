package com.sparta.upgradeschedule.service;
import com.sparta.upgradeschedule.dto.GeneralScheduleResponseDto;
import com.sparta.upgradeschedule.dto.ScheduleRequestDto;
import com.sparta.upgradeschedule.dto.IndividualScheduleResponseDto;
import com.sparta.upgradeschedule.entity.Schedule;
import com.sparta.upgradeschedule.entity.User;
import com.sparta.upgradeschedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserService userService;

    public void createSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule();
        schedule.setUserId(requestDto.getUserId());
        schedule.setTitle(requestDto.getTitle());
        schedule.setContent(requestDto.getContent());
        scheduleRepository.save(schedule);
    }

    public void updateSchedule(Long id, ScheduleRequestDto requestDto) {

        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid schedule ID: " + id));

        schedule.setTitle(requestDto.getTitle());
        schedule.setContent(requestDto.getContent());
    }

    public IndividualScheduleResponseDto getSchedule(long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid schedule ID: " + id));
        User user = userService.returnUser(schedule.getUserId());
        return new IndividualScheduleResponseDto(schedule, user);
    }

    public Schedule returnSchedule(long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid schedule ID: " + id));
        return schedule;
    }

    public Page<GeneralScheduleResponseDto> getSchedules(int page, int size) {
        Sort.Direction direction = Sort.Direction.DESC;
        Sort sort  = Sort.by(direction, "modifiedDate");
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Schedule> schedules = scheduleRepository.findAll(pageable);
        return schedules.map(schedule -> new GeneralScheduleResponseDto(schedule));
    }

    public void deleteSchedule(long id) {
        scheduleRepository.deleteById(id);
    }
}