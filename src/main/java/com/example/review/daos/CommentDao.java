package com.example.review.daos;

import com.example.review.dtos.CommentDTO;
import com.example.review.dtos.CommentsStatisticsDTO;
import com.example.review.models.Comment;

import java.util.List;

public interface CommentDao {
    boolean saveComment(Comment comment);

    boolean updateCommentApprovalStatus(CommentDTO commentDTO);

    List<Comment> getComments();

    List<CommentsStatisticsDTO> statisticsOfProductComments(String productId);

    List<CommentsStatisticsDTO> getLastThreeComments();

    List<Comment> getCommentsOfTheProduct(String productId);
}
