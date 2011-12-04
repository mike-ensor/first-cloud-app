package com.ensor.data.dao;

import com.ensor.data.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleDAO extends MongoRepository<Article, String> {
}
