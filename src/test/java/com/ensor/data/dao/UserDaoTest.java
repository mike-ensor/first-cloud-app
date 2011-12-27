package com.ensor.data.dao;

import com.ensor.data.service.DbHelper;
import com.ensor.model.User;
import com.google.common.base.Throwables;
import com.mongodb.Mongo;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.net.UnknownHostException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = UserDaoTest.UserDaoConfiguration.class)
@Profile("local-mongo")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DbHelper dbHelper;

    @After
    public void tearDown() {
        dbHelper.clear(User.class);
    }

    @Test
    public void persistSingleUser() {
        User user = new User("email@somewhere.com");

        userDao.persist(user);

        User foundUser = userDao.find("email@somewhere.com");

        assertThat(foundUser, is(user));
    }

    @ComponentScan(basePackages = "com.ensor.data")
    static class UserDaoConfiguration {

        @Bean
        public MongoTemplate getMongoTemplate() {
            Mongo mongo;
            try {
                mongo = new Mongo("127.0.0.1", 27017);
            } catch (UnknownHostException e) {
                throw Throwables.propagate(e);
            }
            return new MongoTemplate(mongo, "temp");
        }

    }
}
