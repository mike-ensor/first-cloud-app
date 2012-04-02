package com.ensor.data.service;

import com.ensor.model.Article;
import com.ensor.model.BlogArticle;
import com.google.common.annotations.VisibleForTesting;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.CollectionCallback;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class DbHelper {

    @Autowired
    @VisibleForTesting
    MongoTemplate mongoTemplate;

    public String getDump(Class<?> entityClass) {
        final StringBuilder mongoData = new StringBuilder();
        mongoTemplate.execute(entityClass,
                new CollectionCallback<String>() {
                    public String doInCollection(DBCollection collection) throws MongoException, DataAccessException {
                        for (DBObject dbo : collection.find()) {
                            mongoData.append(dbo.toString());
                            mongoData.append(" ");
                        }
                        return null;
                    }
                });
        String ret = "";
        if (mongoData.length() > 0) {
            ret = mongoTemplate.getCollectionName(entityClass) + " collection: " + mongoData.toString();
        }
        return ret;
    }

    public void clear(Class<?> clazz) {
        if (mongoTemplate.collectionExists(clazz)) {
            mongoTemplate.dropCollection(clazz);
        }
    }

    public void populateArticle() {
        createArticle("Multiple GitHub accounts", "http://www.ensor.cc/2011/12/how-to-setup-several-github-accounts-on.html");
        createArticle("Spring 3.1 + Cloud Foundry + Local Development", "http://www.ensor.cc/2011/12/spring-31-cloud-foundry-local.html");
    }

    private void createArticle(final String subject, final String source) {
        Article article = new BlogArticle(subject, source);
        mongoTemplate.insert(article);
    }

}
