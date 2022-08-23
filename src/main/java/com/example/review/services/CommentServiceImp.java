package com.example.review.services;

import com.example.review.daos.CommentDao;
import com.example.review.dtos.CommentDTO;
import com.example.review.dtos.CommentPermissionDTO;
import com.example.review.dtos.CommentsStatisticsDTO;
import com.example.review.exceptionHandling.ApiNotFoundException;
import com.example.review.exceptionHandling.ApiNullInput;
import com.example.review.models.Comment;
import com.example.review.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.review.enumes.CommentsAccess.EVERYONE;

@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Override
    public boolean saveComment(Comment comment) {
        return commentDao.saveComment(comment);
    }

    @Override
    public boolean updateCommentApprovalStatus(CommentDTO commentDTO) {
        return commentDao.updateCommentApprovalStatus(commentDTO);
    }

    @Override
    public List<Comment> getComments() {
        return commentDao.getComments();
    }

    @Override
    public boolean canUserComment(CommentPermissionDTO permissionCommentDTO) {
        Product product = productService.canUserComment(permissionCommentDTO.getProductId());
        if (product == null) {
            throw new ApiNotFoundException("there's no matched product with sent productId ", HttpStatus.NOT_ACCEPTABLE);
        } else {
            if (product.getCommentsAccess().equals(EVERYONE)) {
                return true;
            } else {
                return orderService.hasPurchased(permissionCommentDTO);
            }
        }
    }

    @Override
    public List<CommentsStatisticsDTO> statisticsOfProductComments(String productId) {
        return commentDao.statisticsOfProductComments(productId);
    }

    @Override
    public List<CommentsStatisticsDTO> getLastThreeComments() {
        return commentDao.getLastThreeComments();
    }

    @Override
    public List<Comment> getCommentsOfTheProduct(String productId) {
        return commentDao.getCommentsOfTheProduct(productId);
    }

}
