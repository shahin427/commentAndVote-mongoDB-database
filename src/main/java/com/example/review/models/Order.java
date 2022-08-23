package com.example.review.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
    @Id
    private String id;
    @NotEmpty(message = "price is not null nor empty")
    private double price;
    @NotEmpty(message = "productIds are not null nor empty")
    private List<String> productIds;
    @NotBlank(message = "userId is mandatory")
    private String userId;
}
