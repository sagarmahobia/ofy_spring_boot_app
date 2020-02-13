package com.ryf.appbackend.core.services;


import com.ryf.appbackend.core.opportunity.models.Opportunities;
import com.ryf.appbackend.core.repository.OpportunityRepository;
import com.ryf.appbackend.jpa.entities.OpportunityEntity;
import com.ryf.appbackend.jpa.entities.enums.OpportunityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityService {


    @Autowired
    OpportunityUtil opportunityUtil;

    @Autowired
    OpportunityRepository opportunityRepository;


    public Opportunities getOpportunitiesForHome() {
        Opportunities opportunities = new Opportunities();


        int page = 0;
        int size = 8;

        List<OpportunityEntity> competitions = opportunityRepository.getOpportunitiesByPageAndSize(OpportunityType.COMPETITIONS, page, size);
        opportunities.setCompetitions(opportunityUtil.getOpportunityFromEntityList(competitions));

        List<OpportunityEntity> grants = opportunityRepository.getOpportunitiesByPageAndSize(OpportunityType.GRANTS, page, size);
        opportunities.setGrants(opportunityUtil.getOpportunityFromEntityList(grants));

//        List<OpportunityEntity> exchangePrograms = opportunityRepository.getOpportunitiesByPageAndSize(OpportunityType.EXCHANGE_PROGRAMS, page, size);
//        opportunities.setExchangePrograms(opportunityUtil.getOpportunityFromEntityList(exchangePrograms));

        List<OpportunityEntity> internships = opportunityRepository.getOpportunitiesByPageAndSize(OpportunityType.INTERNSHIP, page, size);
        opportunities.setInternship(opportunityUtil.getOpportunityFromEntityList(internships));

        List<OpportunityEntity> fellowships = opportunityRepository.getOpportunitiesByPageAndSize(OpportunityType.FELLOWSHIPS, page, size);
        opportunities.setFellowships(opportunityUtil.getOpportunityFromEntityList(fellowships));

        List<OpportunityEntity> conferences = opportunityRepository.getOpportunitiesByPageAndSize(OpportunityType.CONFERENCES, page, size);
        opportunities.setConferences(opportunityUtil.getOpportunityFromEntityList(conferences));

        List<OpportunityEntity> workshops = opportunityRepository.getOpportunitiesByPageAndSize(OpportunityType.WORKSHOPS, page, size);
        opportunities.setWorkshops(opportunityUtil.getOpportunityFromEntityList(workshops));

        List<OpportunityEntity> scholarships = opportunityRepository.getOpportunitiesByPageAndSize(OpportunityType.SCHOLARSHIPS, page, size);
        opportunities.setScholarships(opportunityUtil.getOpportunityFromEntityList(scholarships));

        List<OpportunityEntity> miscellaneous = opportunityRepository.getOpportunitiesByPageAndSize(OpportunityType.MISCELLANEOUS, page, size);
        opportunities.setMiscellaneous(opportunityUtil.getOpportunityFromEntityList(miscellaneous));


        return opportunities;

    }

}
