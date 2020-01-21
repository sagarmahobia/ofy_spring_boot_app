package com.ryf.appbackend.jpa.dao;

import com.ryf.appbackend.jpa.entities.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityDao extends JpaRepository<Opportunity, Long> {

}
