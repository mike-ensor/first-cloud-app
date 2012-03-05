package com.ensor.web.controller;

import com.ensor.data.dao.ArticleRepository;
import com.ensor.model.Article;
import com.ensor.model.BlogArticle;
import com.ensor.web.model.ArticleModel;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    @VisibleForTesting
    ArticleRepository articleRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getView(@ModelAttribute("article") ArticleModel model) {
        Pageable pagable = new PageRequest(0, 10);
        model.setArticles(ImmutableList.copyOf(articleRepository.findAll(pagable)));
        return "article/view";
    }

    @RequestMapping(method = RequestMethod.POST, params = "type=blog")
    public String submit(@ModelAttribute("article") ArticleModel model) {
        Article blog = new BlogArticle(model.getSubject(), model.getFromSource());
        articleRepository.save(blog);
        return "redirect:/article";
    }

}
