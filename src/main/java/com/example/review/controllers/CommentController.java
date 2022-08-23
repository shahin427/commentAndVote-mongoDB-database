package com.example.review.controllers;

import com.example.review.dtos.CommentDTO;
import com.example.review.dtos.CommentPermissionDTO;
import com.example.review.exceptionHandling.ApiNullInput;
import com.example.review.models.Comment;
import com.example.review.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("save")
    public ResponseEntity<?> saveComment(@Valid @RequestBody Comment comment) {
        return ResponseEntity.ok().body(commentService.saveComment(comment));
    }

    @GetMapping("get-comments")
    public ResponseEntity<?> getComments() {
        return ResponseEntity.ok().body(commentService.getComments());
    }

    @PutMapping("update-comment-approval-status")
    public ResponseEntity<?> updateCommentApprovalStatus(@Valid @RequestBody CommentDTO commentDTO) {
        return ResponseEntity.ok().body(commentService.updateCommentApprovalStatus(commentDTO));
    }

    @PostMapping("can-user-comment")
    public ResponseEntity<?> canUserComment(@Valid @RequestBody CommentPermissionDTO permissionCommentDTO) {
        return ResponseEntity.ok().body(commentService.canUserComment(permissionCommentDTO));
    }

    @GetMapping("statistics-of-product-comments")
    public ResponseEntity<?> statisticsOfProductComments(@PathParam("productId") String productId) {
        if (productId == null) {
            throw new ApiNullInput("sent id is null");
        } else {
            return ResponseEntity.ok().body(commentService.statisticsOfProductComments(productId));
        }
    }

    @GetMapping("get-one")
    public ResponseEntity<?> getCommentsOfTheProduct(@PathParam("productId") String productId) {
        if (productId == null) {
            throw new ApiNullInput("sent id is null");
        } else {
            return ResponseEntity.ok().body(commentService.getCommentsOfTheProduct(productId));
        }
    }
}
