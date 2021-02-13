package com.ryf.appbackend.core.repository;


import com.ryf.appbackend.jpa.dao.ArticlesDao;
import com.ryf.appbackend.jpa.entities.ArticlesEntity;
import com.ryf.appbackend.models.dto.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleRepository {

    @Autowired
    private ArticlesDao articlesDao;




    public ArticlesEntity getArticleonid(Long id){

        return articlesDao.getOne(id);
    }

    public Page<ArticlesEntity> getAtricles(int page, int size){

        return articlesDao.findAll(getPageRequestforArticles(page, size));
    }

    public static Pageable getPageRequestforArticles(int page, int size){
        return PageRequest.of(page,size, Sort.by("id").ascending());
    }
}
