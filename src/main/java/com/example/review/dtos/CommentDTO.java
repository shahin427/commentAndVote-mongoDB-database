package com.example.review.dtos;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class CommentDTO {
    @NotBlank(message = "commentId is mandatory")
    private String commentId;
    private boolean approvalStatus;
}
