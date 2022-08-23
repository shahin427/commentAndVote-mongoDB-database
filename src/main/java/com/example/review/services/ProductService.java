package com.example.review.services;


import com.example.review.dtos.ProductDTO;
import com.example.review.models.Product;

import java.util.List;

public interface ProductService {
    boolean saveProduct(Product product);

    List<Product> getProducts();

    Product canUserComment(String productId);

    Product getOneProduct(String productId);

    List<ProductDTO> getAllProductsWithLastThreeComments();
}
