package com.ryf.appbackend.core.repository;

import com.ryf.appbackend.jpa.dao.SubmittedOpportunityDao;
import com.ryf.appbackend.jpa.entities.OpportunityEntity;
import com.ryf.appbackend.jpa.entities.user.SubmittedOpportunityEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class SubmittedOpportunityRepository {
    private SubmittedOpportunityDao opportunityDao;

    public SubmittedOpportunityRepository(SubmittedOpportunityDao opportunityDao) {
        this.opportunityDao = opportunityDao;
    }

    public List<SubmittedOpportunityEntity> findAll(int page, int size) {
        return opportunityDao.findAll(getPageRequestForIdDefending(page, size)).getContent();
    }

    public Pageable getPageRequestForIdDefending(int page, int size) {
        return PageRequest.of(page, size, Sort.by("id").descending());
    }

}
