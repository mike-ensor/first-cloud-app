package com.ensor.data.dao;

import com.ensor.model.User;
import com.google.common.annotations.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

@Repository
public class UserDao {

    @Autowired
    @VisibleForTesting
    MongoTemplate template;

    public User find(String email) {
        checkArgument(!isNullOrEmpty(email), "Email cannot be null");
        return template.findById(email, User.class);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return template.findAll(User.class);
    }

    @Transactional
    public void persist(User user) {
        template.save(user);
    }

}
