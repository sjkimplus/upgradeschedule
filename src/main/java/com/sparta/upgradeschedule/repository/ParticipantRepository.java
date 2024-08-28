package com.sparta.upgradeschedule.repository;

import com.sparta.upgradeschedule.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
