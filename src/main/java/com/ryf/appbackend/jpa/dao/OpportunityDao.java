package com.ryf.appbackend.jpa.dao;

import com.ryf.appbackend.jpa.entities.OpportunityEntity;
import com.ryf.appbackend.jpa.entities.enums.OpportunityType;
import com.ryf.appbackend.jpa.entities.enums.Region;
import com.ryf.appbackend.jpa.entities.user.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityDao extends JpaRepository<OpportunityEntity, Long> {

    List<OpportunityEntity> findAllByOpportunityType(OpportunityType opportunityType, Pageable pageable);

    List<OpportunityEntity> findAllByOpportunityTypeOrOpportunityType(OpportunityType opportunityType1, OpportunityType opportunityType2, Pageable pageable);

    List<OpportunityEntity> findAllByFeatured(boolean featured, Pageable pageable);

    List<OpportunityEntity> findAllByRegion(Region region, Pageable pageable);

    List<OpportunityEntity> findAllByOpportunityTypeAndRegion(OpportunityType opportunityType, Region region, Pageable pageable);

    List<OpportunityEntity> findByTitleLikeIgnoreCase(String title, Pageable pageable);

    List<OpportunityEntity> findAllByUser(User user, Pageable pageable);
}
