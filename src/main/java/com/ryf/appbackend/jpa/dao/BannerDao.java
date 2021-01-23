package com.ryf.appbackend.jpa.dao;

import com.ryf.appbackend.jpa.entities.BannerEntity;
import com.ryf.appbackend.models.dto.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerDao extends JpaRepository<BannerEntity,Long> {

}
