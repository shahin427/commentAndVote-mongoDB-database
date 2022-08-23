package com.example.review.daos;

import com.example.review.dtos.CommentPermissionDTO;
import com.example.review.models.Order;

public interface OrderDao {
    boolean hasPurchased(CommentPermissionDTO permissionCommentDTO);

    boolean saveOrder(Order order);
}
