package com.example.review.daos;

import com.example.review.dtos.CommentPermissionDTO;
import com.example.review.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImp implements OrderDao {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public boolean hasPurchased(CommentPermissionDTO permissionCommentDTO) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productIds").in(permissionCommentDTO.getProductId()));
        query.addCriteria(Criteria.where("userId").is(permissionCommentDTO.getUserId()));
        return mongoOperations.exists(query, Order.class);
    }

    @Override
    public boolean saveOrder(Order order) {
        Order savedOrder = mongoOperations.save(order);
        return savedOrder.getId() != null;
    }
}
