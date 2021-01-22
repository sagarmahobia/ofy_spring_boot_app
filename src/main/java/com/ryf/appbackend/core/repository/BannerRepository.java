package com.ryf.appbackend.core.repository;

import com.ryf.appbackend.jpa.dao.BannerDao;
import com.ryf.appbackend.jpa.entities.ArticlesEntity;
import com.ryf.appbackend.jpa.entities.BannerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class BannerRepository {

    @Autowired
    private BannerDao bannerDao;

    public void saveBannerEntity(BannerEntity bannerEntity){

        bannerDao.save(bannerEntity);
    }

    public BannerEntity getOne(Long id) {

        return bannerDao.getOne(id);
    }

    public Page<BannerEntity> getAtricles(int page, int size){

        return bannerDao.findAll(getPageRequestforArticles(page, size));
    }

    public static Pageable getPageRequestforArticles(int page, int size){
        return PageRequest.of(page,size, Sort.by("id").ascending());
    }
}
