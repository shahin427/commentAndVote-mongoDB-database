package com.example.review.daos;

import com.example.review.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImp implements ProductDao {


    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public boolean saveProduct(Product product) {
        Product savedProduct = mongoOperations.save(product);
        return savedProduct.getId() != null;
    }

    @Override
    public List<Product> getProducts() {
        Query query = new Query();
        query.addCriteria(Criteria.where("showProduct").is(true));
        return mongoOperations.find(query, Product.class);
    }

    @Override
    public Product canUserComment(String productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(productId));
        query.fields()
                .include("commentsAccess");
        return mongoOperations.findOne(query, Product.class);
    }

    @Override
    public Product getOneProduct(String productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(productId));
        query.fields()
                .exclude("commentsAccess")
                .exclude("enterpriseName")
                .exclude("price");
        return mongoOperations.findOne(query, Product.class);
    }
}
