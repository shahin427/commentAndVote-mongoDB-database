package com.example.review.controllers;

import com.example.review.exceptionHandling.ApiNullInput;
import com.example.review.models.Product;
import com.example.review.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("save")
    public ResponseEntity<?> saveProduct(@Valid @RequestBody Product product) {
        return ResponseEntity.ok().body(productService.saveProduct(product));
    }

    @GetMapping("get-products")
    public ResponseEntity<?> getProducts() {
        return ResponseEntity.ok().body(productService.getProducts());
    }

    @GetMapping("get-one")
    public ResponseEntity<?> getOneProduct(@PathParam("productId") String productId) {
        if (productId == null) {
            throw new ApiNullInput("input param is null");
        } else {
            return ResponseEntity.ok().body(productService.getOneProduct(productId));
        }
    }

    @GetMapping("get-all-products-with-comments")
    public ResponseEntity<?> getAllProductsWithLastThreeComments() {
        return ResponseEntity.ok().body(productService.getAllProductsWithLastThreeComments());
    }
}
