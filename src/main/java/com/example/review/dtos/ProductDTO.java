package com.example.review.dtos;

import com.example.review.models.Comment;
import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {
    private String productId;
    private String productName;
    private boolean showProduct;
    private boolean showComment;
    private boolean showVote;
    private float price;
    private float votesAverage;
    private int numberOfComments;
    private List<Comment> comments;

}
