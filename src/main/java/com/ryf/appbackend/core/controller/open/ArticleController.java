package com.ryf.appbackend.core.controller.open;

import com.ryf.appbackend.core.services.ArticleService;
import com.ryf.appbackend.models.dto.Article;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
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

    @GetMapping("/v1/public/filter/{heading}/{headingtype}")
    public List<Article> filterArticlebyheadingAndHeadingType(@PathVariable String heading,@PathVariable String headingtype,
                                                             @RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                             @RequestParam(value = "size", defaultValue = "10", required = false) int size){


        return articleService.getArticlesonHeadingandHeadingType(heading,headingtype,page,size);
    }


}
