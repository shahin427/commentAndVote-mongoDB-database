package com.example.review.services;

import com.example.review.dtos.CommentPermissionDTO;
import com.example.review.models.Order;

public interface OrderService {
    boolean hasPurchased(CommentPermissionDTO permissionCommentDTO);

    boolean saveOrder(Order order);
}
