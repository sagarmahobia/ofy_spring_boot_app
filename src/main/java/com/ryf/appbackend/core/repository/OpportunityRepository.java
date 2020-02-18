package com.ryf.appbackend.core.repository;


import com.ryf.appbackend.core.services.OpportunityUtil;
import com.ryf.appbackend.jpa.dao.ImageDao;
import com.ryf.appbackend.jpa.dao.OpportunityDao;
import com.ryf.appbackend.jpa.entities.OpportunityEntity;
import com.ryf.appbackend.jpa.entities.enums.OpportunityType;
import com.ryf.appbackend.jpa.entities.enums.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OpportunityRepository {

    @Autowired
    OpportunityDao opportunityDao;


    @Autowired
    ImageDao imageDao;

    @Autowired
    OpportunityUtil opportunityUtil;


    public List<OpportunityEntity> getFeaturedOpportunitiesByPageAndSize(int page, int size) {
        List<OpportunityEntity> allByFeatured = opportunityDao.findAllByFeatured(true, getPageRequestForIdDefending(page, size));
        return allByFeatured;
    }

    /**
     * @param opportunityType type
     * @param page            start at 0
     * @param size            no of element in single page
     * @return list of opportunities
     */
    public List<OpportunityEntity> getOpportunitiesByPageAndSize(OpportunityType opportunityType, int page, int size) {
        return opportunityDao.findAllByOpportunityType(opportunityType, getPageRequestForIdDefending(page, size));
    }

    public List<OpportunityEntity> getOpportunitiesByPageAndSize(OpportunityType opportunityType1, OpportunityType opportunityType2, int page, int size) {
        return opportunityDao.findAllByOpportunityTypeOrOpportunityType(opportunityType1, opportunityType2, getPageRequestForIdDefending(page, size));
    }

    public List<OpportunityEntity> findAll(int page, int size) {
        return opportunityDao.findAll(getPageRequestForIdDefending(page, size)).getContent();
    }

    public List<OpportunityEntity> findAllByOpportunityType(OpportunityType type, int page, int size) {
        return opportunityDao.findAllByOpportunityType(type, getPageRequestForIdDefending(page, size));

    }

    public List<OpportunityEntity> findAllByRegion(Region region, int page, int size) {

        return opportunityDao.findAllByRegion(region, getPageRequestForIdDefending(page, size));

    }

    public List<OpportunityEntity> findAllByOpportunityTypeAndRegion(OpportunityType type, Region region, int page, int size) {
        return opportunityDao.findAllByOpportunityTypeAndRegion(type, region, getPageRequestForIdDefending(page, size));

    }


    private Pageable getPageRequestForIdDefending(int page, int size) {
        return PageRequest.of(page, size, Sort.by("id").descending());
    }

}

