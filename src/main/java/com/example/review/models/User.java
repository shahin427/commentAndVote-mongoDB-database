package com.example.review.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotBlank;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @Id
    private String id;
    @NotBlank(message = "name is mandatory")
    private String name;
    @NotBlank(message = "familyName is mandatory")
    private String familyName;
    @JsonFormat(pattern = PatternList.email)
    private String email;
}
