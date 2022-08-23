package com.example.review.models;

import com.example.review.enumes.CommentsAccess;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    @Id
    private String id;
    @NotBlank(message = "name is mandatory")
    private String name;
    private String enterpriseName;
    @NotBlank(message = "price is mandatory")
    private float price;
    private boolean showProduct;
    private boolean showComment;
    private boolean showVote;
    private CommentsAccess commentsAccess;
}
