package com.ryf.appbackend.core.controller.open;

import com.ryf.appbackend.core.services.ArticleService;
import com.ryf.appbackend.core.services.CatagoryService;
import com.ryf.appbackend.models.dto.Article;
import com.ryf.appbackend.models.dto.CatagoryAndSubDto;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ArticleController {

    private final ArticleService articleService;
    private final CatagoryService catagoryService;

    public ArticleController(ArticleService articleService,CatagoryService catagoryService){
        this.articleService = articleService;
        this.catagoryService = catagoryService;
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

    @GetMapping("/v1/public/getCatagoriesandSubCatagories")
    public CatagoryAndSubDto getALLCatagories(){


        return CatagoryAndSubDto.builder()
                .articleCatagoryDtoList(catagoryService.getAllCatagories())
                .subCatagoryList(catagoryService.getAllSubCatagories())
                .build();
    }


}
