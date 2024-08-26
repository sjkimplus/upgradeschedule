package com.sparta.upgradeschedule.controller;

import com.sparta.upgradeschedule.dto.CommentRequestDto;
import com.sparta.upgradeschedule.dto.CommentResponseDto;
import com.sparta.upgradeschedule.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    // 댓글 저장
    @PostMapping("/comments/{id}")
    public void createComment(@PathVariable("id") long scheduleId, @RequestBody CommentRequestDto requestDto) {
        commentService.createComment(scheduleId, requestDto);
    }

    // 댓글 수정
    @PutMapping("/comments/{id}")
    public void updateComment(@PathVariable("id") long commentId, @RequestBody CommentRequestDto requestDto) {
        commentService.updateComment(commentId, requestDto);
    }

    // 댓글 단건 조회
    @GetMapping("/comments/{id}")
    public CommentResponseDto getComment(@PathVariable("id") long commentId) {
        return  commentService.getComment(commentId);
    }

    // 단건 스케줄에 있는 댓글 전체 조회
    @GetMapping("/comments")
    public List<CommentResponseDto> getComments(@RequestParam("id") long scheduleId) {
        return  commentService.getComments(scheduleId);
    }

    // 댓글 삭제
    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable("id") long commentId) {
        commentService.deleteComment(commentId);
    }
}
