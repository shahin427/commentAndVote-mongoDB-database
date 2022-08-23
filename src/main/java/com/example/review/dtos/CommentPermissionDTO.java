package com.example.review.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CommentPermissionDTO {
    @NotBlank(message = "userId is mandatory")
    private String userId;
    @NotBlank(message = "productId is mandatory")
    private String productId;
}
