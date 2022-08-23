package com.example.review.daos;

import com.example.review.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public boolean saveUser(User user) {
        User savedUser = mongoOperations.save(user);
        return savedUser.getId() != null;
    }
}
