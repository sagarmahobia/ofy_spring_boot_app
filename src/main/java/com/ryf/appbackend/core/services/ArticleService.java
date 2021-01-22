package com.ryf.appbackend.core.services;

import com.ryf.appbackend.core.repository.ArticleRepository;
import com.ryf.appbackend.jpa.dao.ArticlesDao;
import com.ryf.appbackend.jpa.entities.ArticlesEntity;
import com.ryf.appbackend.models.dto.Article;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    public Article EntitytoDto(ArticlesEntity entity){

        return Article.builder()
                .heading(entity.getHeading())
                .headingLink(entity.getHeadingLink())
                .headingType(entity.getHeadingType())
                .imageLink(entity.getImageLink())
                .subCatagory(entity.getSubCatagory())
                .catagory(entity.getCatagory())
                .id(entity.getId())
                .build();
    }


  public Article getAtricleOnid(Long id){
        return EntitytoDto(articleRepository.getArticleonid(id));
  }

  public List<Article> getArticlesOnPaging(int page,int size){

        return articleRepository.getAtricles(page, size).toList()
                .parallelStream()
                .map(this::EntitytoDto)
                .collect(Collectors.toList());
  }




}
