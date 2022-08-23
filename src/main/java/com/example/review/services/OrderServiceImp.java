package com.example.review.services;

import com.example.review.daos.OrderDao;
import com.example.review.dtos.CommentPermissionDTO;
import com.example.review.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public boolean hasPurchased(CommentPermissionDTO permissionCommentDTO) {
        return orderDao.hasPurchased(permissionCommentDTO);
    }

    @Override
    public boolean saveOrder(Order order) {
        return orderDao.saveOrder(order);
    }
}
