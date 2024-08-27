package com.sparta.upgradeschedule.repository;

import com.sparta.upgradeschedule.dto.ScheduleResponseDto;
import com.sparta.upgradeschedule.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
