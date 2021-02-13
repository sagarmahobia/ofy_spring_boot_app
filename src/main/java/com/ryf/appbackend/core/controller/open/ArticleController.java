package com.ryf.appbackend.core.controller.open;

import com.ryf.appbackend.core.services.ArticleService;
import com.ryf.appbackend.models.dto.Article;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }

    @GetMapping("/v1/public/article")
    public Article getOneArticle(@RequestParam("id") Long id){

        return articleService.getAtricleOnid(id);
    }

    @GetMapping("/v1/public/articles")
    public List<Article> getArticlesonPageAndSize(@RequestParam(value = "page",required = true,defaultValue = "0") int page,
                                     @RequestParam(value = "size",required = true,defaultValue = "8") int size){

        return articleService.getArticlesOnPaging(page, size);
    }


}
