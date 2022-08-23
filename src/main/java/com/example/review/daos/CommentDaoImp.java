package com.example.review.daos;

import com.example.review.dtos.CommentDTO;
import com.example.review.dtos.CommentsStatisticsDTO;
import com.example.review.models.Comment;
import com.mongodb.BasicDBObject;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImp implements CommentDao {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public boolean saveComment(Comment comment) {
        Comment savedComment = mongoOperations.save(comment);
        return savedComment.getId() != null;
    }


    @Override
    public boolean updateCommentApprovalStatus(CommentDTO commentDTO) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(commentDTO.getCommentId()));
        Update update = new Update();
        update.set("approvalStatus", commentDTO.isApprovalStatus());
        UpdateResult updateResult = mongoOperations.updateFirst(query, update, Comment.class);
        return updateResult.getModifiedCount() > 0;
    }

    @Override
    public List<Comment> getComments() {
        return mongoOperations.findAll(Comment.class);
    }

    @Override
    public List<CommentsStatisticsDTO> statisticsOfProductComments(String productId) {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("productId").is(productId)),
                Aggregation.match(Criteria.where("approvalStatus").is(true)),
                Aggregation.sort(Sort.Direction.DESC, "recordDate"),
                Aggregation.group("productId")
                        .count().as("numberOfComments")
                        .avg("vote").as("votesAverage")
                        .push(new BasicDBObject
                                ("text", "$text").append
                                ("vote", "$vote")).as("comments"),
                Aggregation.project()
                        .and("numberOfComments").as("numberOfComments")
                        .and("votesAverage").as("votesAverage")
                        .and("comments").slice(3)
        );
        return mongoOperations.aggregate(aggregation, Comment.class, CommentsStatisticsDTO.class).getMappedResults();
    }

    @Override
    public List<CommentsStatisticsDTO> getLastThreeComments() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("approvalStatus").is(true)),
                Aggregation.sort(Sort.Direction.DESC, "recordDate"),
                Aggregation.group("productId")
                        .count().as("numberOfComments")
                        .avg("vote").as("votesAverage")
                        .first("productId").as("productId")
                        .push(new BasicDBObject
                                ("text", "$text").append
                                ("vote", "$vote")).as("comments"),
                Aggregation.project()
                        .and("numberOfComments").as("numberOfComments")
                        .and("votesAverage").as("votesAverage")
                        .and("productId").as("productId")
                        .and("comments").slice(3)
        );
        return mongoOperations.aggregate(aggregation, Comment.class, CommentsStatisticsDTO.class).getMappedResults();
    }

    @Override
    public List<Comment> getCommentsOfTheProduct(String productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        return mongoOperations.find(query,Comment.class);
    }

}
