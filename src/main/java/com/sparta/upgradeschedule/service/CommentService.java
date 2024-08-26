package com.sparta.upgradeschedule.service;

import com.sparta.upgradeschedule.dto.CommentRequestDto;
import com.sparta.upgradeschedule.dto.CommentResponseDto;
import com.sparta.upgradeschedule.entity.Comment;
import com.sparta.upgradeschedule.entity.Schedule;
import com.sparta.upgradeschedule.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    private final ScheduleService scheduleService;
    private final CommentRepository commentRepository;

    // 저장
    public void createComment(Long scheduleId, CommentRequestDto requestDto) {
        // make comment
        Comment comment = new Comment();
        comment.setComment(requestDto.getComment());
        comment.setUser(requestDto.getUser());

        // get schedule
        Schedule schedule = scheduleService.returnSchedule(scheduleId);

        // set up a relationship
        comment.setSchedule(schedule);
        schedule.getCommentList().add(comment);
        commentRepository.save(comment);
    }

    // 수정
    public void updateComment(Long id, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid schedule ID: " + id));
        comment.setComment(requestDto.getComment());
    }

    // 단건조회
    public CommentResponseDto getComment(long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid schedule ID: " + commentId));

        CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
        return commentResponseDto;
    }

    // 단건 스케줄에 있는 댓글 전체 조회
    public List<CommentResponseDto> getComments(long scheduleId) {
        // Fetch comments associated with the given scheduleId
        List<Comment> comments = commentRepository.findByScheduleId(scheduleId);

        // Convert Comment entities to CommentResponseDto using the constructor
        return comments.stream()
                .map(CommentResponseDto::new) // Use the constructor to create DTOs
                .collect(Collectors.toList());
    }

    // 삭제
    public void deleteComment(long commentId) {
        commentRepository.deleteById(commentId);
    }







}
