package com.ryf.appbackend.jpa.dao;

import com.ryf.appbackend.jpa.entities.OpportunityEntity;
import com.ryf.appbackend.jpa.entities.enums.OpportunityType;
import com.ryf.appbackend.jpa.entities.enums.Region;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityDao extends JpaRepository<OpportunityEntity, Long> {

    List<OpportunityEntity> findAllByOpportunityType(OpportunityType opportunityType);

    List<OpportunityEntity> findAllByOpportunityType(OpportunityType opportunityType, Pageable pageable);

    List<OpportunityEntity> findAllByRegion(Region region);

    List<OpportunityEntity> findAllByOpportunityTypeAndRegion(OpportunityType opportunityType, Region region);


}
