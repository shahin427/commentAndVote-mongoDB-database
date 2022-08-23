package com.example.review.daos;

import com.example.review.models.Product;

import java.util.List;

public interface ProductDao {

    boolean saveProduct(Product product);

    List<Product> getProducts();

    Product canUserComment(String productId);

    Product getOneProduct(String productId);
}
