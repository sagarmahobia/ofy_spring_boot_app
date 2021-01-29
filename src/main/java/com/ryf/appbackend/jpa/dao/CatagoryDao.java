package com.ryf.appbackend.jpa.dao;

import com.amazonaws.services.dynamodbv2.xspec.L;
import com.ryf.appbackend.jpa.entities.CatagoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatagoryDao extends JpaRepository<CatagoryEntity, Long> {


}
