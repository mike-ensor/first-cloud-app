package com.ensor.data.dao;

import com.ensor.data.service.DbHelper;
import com.ensor.model.Article;
import com.ensor.model.BlogArticle;
import com.ensor.model.MagazineArticle;
import com.ensor.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/article-test-context.xml")
public class ArticleRepositoryTest {

    @Autowired
    private DbHelper dbHelper;

    @Autowired
    private ArticleRepository articleRepository;

    @Before
    public void setUp() {
        assertThat(articleRepository, is(notNullValue()));
    }

    @After
    public void tearDown() {
        dbHelper.clear(Article.class);
    }

    @Test
    public void saveBlogArticle() {
        Article originalArticle = new BlogArticle("Some Subject", "http://www.blah.com");

        articleRepository.save(originalArticle);

        List<Article> articles = articleRepository.findAll();

        assertThat(articles.size(), is(1));
        Article foundArticle = articles.get(0);
        assertThat(foundArticle.getSubject(), is("Some Subject"));
    }

    @Test
    public void saveMagazineArticle() {

        User user = new User("email@example.com");
        Article originalArticle = new MagazineArticle(user, "Subject");

        articleRepository.save(originalArticle);

        List<Article> articles = articleRepository.findAll();

        assertThat(articles.size(), is(1));
        Article foundArticle = articles.get(0);
        assertThat(foundArticle.getSubject(), is("Subject"));
    }

}
