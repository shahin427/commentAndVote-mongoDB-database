package com.example.review.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Comment {

    @Id
    private String id;
    private String text;
    @Nullable
    private float vote;
    private boolean approvalStatus;
    @NotBlank(message = "productId is mandatory")
    private String productId;
    @NotBlank(message = "userId is mandatory")
    private String userId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date recordDate;
}
