package com.ryf.appbackend.core.services;

import com.ryf.appbackend.core.repository.BannerRepository;
import com.ryf.appbackend.jpa.dao.BannerDao;
import com.ryf.appbackend.jpa.entities.BannerEntity;
import com.ryf.appbackend.models.dto.Banner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BannerService {

    private BannerRepository bannerRepository;

    public BannerService(BannerRepository bannerRepository){
        this.bannerRepository = bannerRepository;
    }

    public Banner EntitytoDto(BannerEntity entity){

        return Banner.builder()
                .id(entity.getId())
                .link(entity.getLink())
                .banner(entity.getBanner())
                .build();
    }

    public Banner getBannerOnid(Long id) {

        return EntitytoDto(bannerRepository.getOne(id));
    }

    public List<Banner> getArticlesOnPaging(int page, int size) {

        return bannerRepository.getAtricles(page, size).toList()
                .parallelStream()
                .map(this::EntitytoDto)
                .collect(Collectors.toList());
    }


}
