package com.ryf.appbackend.jpa.dao;

import com.ryf.appbackend.jpa.entities.ArticlesEntity;
import com.ryf.appbackend.models.dto.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesDao extends JpaRepository<ArticlesEntity,Long> {

}
