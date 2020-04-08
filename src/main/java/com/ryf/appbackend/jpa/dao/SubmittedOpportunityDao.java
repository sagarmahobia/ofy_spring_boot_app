package com.ryf.appbackend.jpa.dao;

import com.ryf.appbackend.jpa.entities.OpportunityEntity;
import com.ryf.appbackend.jpa.entities.user.SubmittedOpportunityEntity;
import com.ryf.appbackend.jpa.entities.user.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmittedOpportunityDao extends JpaRepository<SubmittedOpportunityEntity, Long> {

    List<SubmittedOpportunityEntity> findAllByUser(User user, Pageable pageable);

}
