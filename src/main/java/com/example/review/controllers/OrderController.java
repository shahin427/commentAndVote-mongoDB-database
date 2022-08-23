package com.example.review.controllers;

import com.example.review.models.Order;
import com.example.review.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("save")
    public ResponseEntity<?> saveOrder(@Valid @RequestBody Order order) {
        return ResponseEntity.ok().body(orderService.saveOrder(order));
    }

}
