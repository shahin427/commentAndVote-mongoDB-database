package com.example.review.dtos;

import com.example.review.models.Comment;
import lombok.Data;

import java.util.List;

@Data
public class CommentsStatisticsDTO {
    private float votesAverage;
    private int numberOfComments;
    private String productId;
    private List<Comment> comments;
}
