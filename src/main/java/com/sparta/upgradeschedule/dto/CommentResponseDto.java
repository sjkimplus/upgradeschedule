package com.sparta.upgradeschedule.dto;
import com.sparta.upgradeschedule.entity.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponseDto {
    private String user;
    private String comment;
    private String createdDate;
    private String modifiedDate;

    public CommentResponseDto(Comment comment) {
        this.user = comment.getUser();
        this.comment = comment.getComment();
        this.createdDate = String.valueOf(comment.getCreatedDate());
        this.modifiedDate = String.valueOf(comment.getModifiedDate());
    }
}
