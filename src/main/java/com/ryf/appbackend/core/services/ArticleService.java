package com.ryf.appbackend.core.services;

import com.ryf.appbackend.core.repository.ArticleRepository;
import com.ryf.appbackend.jpa.dao.ArticlesDao;
import com.ryf.appbackend.jpa.dao.CatagoryDao;
import com.ryf.appbackend.jpa.dao.SubCatagoryDao;
import com.ryf.appbackend.jpa.entities.ArticlesEntity;
import com.ryf.appbackend.jpa.entities.CatagoryEntity;
import com.ryf.appbackend.jpa.entities.SubCatagoryEntity;
import com.ryf.appbackend.models.dto.Article;
import com.ryf.appbackend.models.dto.SubCatagory;
import com.ryf.appbackend.models.dto.catagory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CatagoryDao catagoryDao;
    private final SubCatagoryDao subCatagoryDao;

    public ArticleService(ArticleRepository articleRepository,CatagoryDao catagoryDao,SubCatagoryDao subCatagoryDao){
        this.articleRepository = articleRepository;
        this.catagoryDao = catagoryDao;
        this.subCatagoryDao = subCatagoryDao;
    }

    public Article EntitytoDto(ArticlesEntity entity){

        return Article.builder()
                .heading(entity.getHeading())
                .headingLink(entity.getHeadingLink())
                .headingType(entity.getHeadingType())
                .imageLink(entity.getImageLink())
                .subCatagoryEntity(entity.getSubCatagoryEntity())
                .catagory(entity.getCatagoryEntity())
                .id(entity.getId())
                .build();
    }

    public SubCatagoryEntity newSubCatagorytoEntity(SubCatagory subcatagory){

        return SubCatagoryEntity.builder()
                .id(subcatagory.getId())
                .subCatagoryName(subcatagory.getSubCatagoryName())
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


    public List<Article> getArticlesonHeadingandHeadingType(String heading, String headingtype, int page, int size) {

        return articleRepository.getArticlesonHeadingandHeadingType(heading,headingtype,page,size).toList()
                .parallelStream()
                .map(this::EntitytoDto)
                .collect(Collectors.toList());
    }

    public void saveArticle(String headingLink, String heading, String headingType, String imageLink, Long catagoryid, List<SubCatagory> subCatagoryEntity, String newcatagory, List<String> newSubcatagory) {
            List<SubCatagoryEntity> newSubCatagorylist = new ArrayList<>();


            if(!newSubcatagory.isEmpty()){

                        newSubcatagory.stream()
                        .map(r-> SubCatagoryEntity.builder().subCatagoryName(r).build())
                        .map(subCatagoryDao::save)
                        .forEach(newSubCatagorylist::add);
            }

            if(!subCatagoryEntity.isEmpty()){

                         subCatagoryEntity.stream()
                        .map(this::newSubCatagorytoEntity)
                        .forEach(newSubCatagorylist::add);

            }

            if(newcatagory != "NO_VALUE"){

              CatagoryEntity  entity = catagoryDao.save(CatagoryEntity
                                            .builder()
                                            .catagoryName(newcatagory)
                                            .build());

                articleRepository.save(ArticlesEntity.builder()
                .heading(heading)
                .headingLink(headingLink)
                .catagoryEntity(entity)
                .subCatagoryEntity(newSubCatagorylist)
                .headingType(headingType)
                .imageLink(imageLink)
                .build());
            }else{
                articleRepository.save(ArticlesEntity.builder()
                        .heading(heading)
                        .headingLink(headingLink)
                        .headingType(headingType)
                        .imageLink(imageLink)
                        .catagoryEntity(catagoryDao.getOne(catagoryid))
                        .subCatagoryEntity(newSubCatagorylist)
                        .build());
            }

    }

    public void editArticle(Long id,String headingLink, String heading, String headingType, String imageLink, Long catagoryid, List<SubCatagory> subCatagoryEntity, String newcatagory, List<String> newSubcatagory) {
        List<SubCatagoryEntity> newSubCatagorylist = new ArrayList<>();


        if(!newSubcatagory.isEmpty()){

            newSubcatagory.stream()
                    .map(r-> SubCatagoryEntity.builder().subCatagoryName(r).build())
                    .map(subCatagoryDao::save)
                    .forEach(newSubCatagorylist::add);
        }

        if(!subCatagoryEntity.isEmpty()){

            subCatagoryEntity.stream()
                    .map(this::newSubCatagorytoEntity)
                    .forEach(newSubCatagorylist::add);

        }

        if(newcatagory != "NO_VALUE"){

            CatagoryEntity  entity = catagoryDao.save(CatagoryEntity
                    .builder()
                    .catagoryName(newcatagory)
                    .build());

            ArticlesEntity entity1 = articleRepository.getArticleonid(id);

            entity1.setHeading(heading);
            entity1.setHeadingLink(headingLink);
            entity1.setImageLink(imageLink);
            entity1.setHeadingType(headingType);
            entity1.setCatagoryEntity(entity);
            entity1.setSubCatagoryEntity(newSubCatagorylist);
            articleRepository.save(entity1);

        }else{

            ArticlesEntity entity1 = articleRepository.getArticleonid(id);

            entity1.setHeading(heading);
            entity1.setHeadingLink(headingLink);
            entity1.setImageLink(imageLink);
            entity1.setHeadingType(headingType);
            entity1.setCatagoryEntity(catagoryDao.getOne(catagoryid));
            entity1.setSubCatagoryEntity(newSubCatagorylist);

            articleRepository.save(entity1);
        }

    }
}
