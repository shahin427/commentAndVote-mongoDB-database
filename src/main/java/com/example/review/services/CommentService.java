package com.example.review.services;

import com.example.review.dtos.CommentDTO;
import com.example.review.dtos.CommentPermissionDTO;
import com.example.review.dtos.CommentsStatisticsDTO;
import com.example.review.models.Comment;

import java.util.List;

public interface CommentService {
    boolean saveComment(Comment comment);

    boolean updateCommentApprovalStatus(CommentDTO commentDTO);

    List<Comment> getComments();

    boolean canUserComment(CommentPermissionDTO permissionCommentDTO);

    List<CommentsStatisticsDTO> statisticsOfProductComments(String productId);

    List<CommentsStatisticsDTO> getLastThreeComments();

    List<Comment> getCommentsOfTheProduct(String productId);
}
