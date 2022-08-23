package com.example.review.services;

import com.example.review.daos.ProductDao;
import com.example.review.dtos.CommentsStatisticsDTO;
import com.example.review.dtos.ProductDTO;
import com.example.review.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CommentService commentService;

    @Override
    public boolean saveProduct(Product product) {
        return productDao.saveProduct(product);
    }

    @Override
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @Override
    public Product canUserComment(String productId) {
        return productDao.canUserComment(productId);
    }

    @Override
    public Product getOneProduct(String productId) {
        return productDao.getOneProduct(productId);
    }

    @Override
    public List<ProductDTO> getAllProductsWithLastThreeComments() {
        List<Product> products = productDao.getProducts();
        List<CommentsStatisticsDTO> commentsStatisticsDTOS = commentService.getLastThreeComments();
        List<ProductDTO> productDTOS = new ArrayList<>();
        products.forEach(product -> {
            commentsStatisticsDTOS.forEach(commentsStatisticsDTO -> {
                if (product.getId().equals(commentsStatisticsDTO.getProductId())) {
                    ProductDTO productDTO = new ProductDTO();
                    productDTO.setProductId(product.getId());
                    productDTO.setProductName(product.getName());
                    productDTO.setPrice(product.getPrice());
                    productDTO.setShowProduct(product.isShowProduct());
                    productDTO.setShowComment(product.isShowComment());
                    productDTO.setShowVote(product.isShowVote());
                    productDTO.setNumberOfComments(commentsStatisticsDTO.getNumberOfComments());
                    productDTO.setVotesAverage(commentsStatisticsDTO.getVotesAverage());
                    productDTO.setComments(commentsStatisticsDTO.getComments());
                    productDTOS.add(productDTO);
                }
            });
        });
        return productDTOS;
    }
}
