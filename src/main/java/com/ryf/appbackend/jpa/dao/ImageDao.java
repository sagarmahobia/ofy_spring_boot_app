package com.ryf.appbackend.jpa.dao;

import com.ryf.appbackend.jpa.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDao extends JpaRepository<Image, Long> {

}
