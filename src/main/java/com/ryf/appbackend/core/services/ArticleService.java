package com.ryf.appbackend.core.services;

import com.ryf.appbackend.core.repository.ArticleRepository;
import com.ryf.appbackend.jpa.dao.ArticlesDao;
import com.ryf.appbackend.jpa.dao.CatagoryDao;
import com.ryf.appbackend.jpa.entities.ArticlesEntity;
import com.ryf.appbackend.jpa.entities.Catagory;
import com.ryf.appbackend.jpa.entities.CatagoryEntity;
import com.ryf.appbackend.jpa.entities.SubCatagoryEntity;
import com.ryf.appbackend.models.dto.Article;
import com.ryf.appbackend.models.dto.SubCatagory;
import com.ryf.appbackend.models.dto.catagory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CatagoryDao catagoryDao;

    public ArticleService(ArticleRepository articleRepository,CatagoryDao catagoryDao){
        this.articleRepository = articleRepository;
        this.catagoryDao = catagoryDao;
    }

    public Article EntitytoDto(ArticlesEntity entity){

        CatagoryEntity catagoryEntity = entity.getCatagoryEntity();

        if(catagoryEntity == null){
            return Article.builder()
                    .heading(entity.getHeading())
                    .headingLink(entity.getHeadingLink())
                    .headingType(entity.getHeadingType())
                    .imageLink(entity.getImageLink())
                    .id(entity.getId())
                    .build();
        }


        return Article.builder()
                .heading(entity.getHeading())
                .headingLink(entity.getHeadingLink())
                .headingType(entity.getHeadingType())
                .imageLink(entity.getImageLink())
                .catagory(catagoryEntityToDto(entity.getCatagoryEntity()))
                .id(entity.getId())
                .build();
    }

    public catagory catagoryEntityToDto(CatagoryEntity catagoryEntity){

        return catagory.builder()
                .id(catagoryEntity.getId())
                .catagoryName(catagoryEntity.getCatagoryName())
                .subCatagoryList(catagoryEntity.getSubCatagoryEntity().stream().map(this::subCatagoryEntityToDto).collect(Collectors.toList()))
                .build();
    }

    public SubCatagory subCatagoryEntityToDto(SubCatagoryEntity subCatagoryEntity){

        return SubCatagory.builder()
                .id(subCatagoryEntity.getId())
                .subCatagoryName(subCatagoryEntity.getSubCatagoryName())
                .parentCatagoryId(subCatagoryEntity.getParentCatagoryId())
                .build();
    }


  public Article getAtricleOnid(Long id){
        return EntitytoDto(articleRepository.getArticleonid(id));
  }

  public List<Article> getArticlesOnPaging(int page,int size){

        return articleRepository.getAtricles(page, size).toList()
                .stream()
                .map(this::EntitytoDto)
                .collect(Collectors.toList());
  }

    public List<Article> getArticlesonHeadingandHeadingType(String heading, String headingtype, int page, int size) {

        return articleRepository.getArticlesonHeadingandHeadingType(heading,headingtype,page,size).toList()
                .parallelStream()
                .map(this::EntitytoDto)
                .collect(Collectors.toList());
    }

    public void editArticle(Long id,String headingLink, String heading, String headingType, String imageLink, Long catagoryid) {
        ArticlesEntity entity = articleRepository.getArticleonid(id);

        if(!headingLink.isEmpty())
            entity.setHeadingLink(headingLink);
        if(!heading.isEmpty())
            entity.setHeading(heading);
        if(!headingType.isEmpty())
            entity.setHeadingType(headingType);
        if(!imageLink.isEmpty())
            entity.setImageLink(imageLink);
        if(catagoryid != null) {
            CatagoryEntity catagoryEntity = catagoryDao.getOne(catagoryid);
            entity.setCatagoryEntity(catagoryEntity);
        }
        articleRepository.save(entity);




    }


}
