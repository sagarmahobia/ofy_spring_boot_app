package com.ryf.appbackend.core.services;


import com.ryf.appbackend.jpa.entities.enums.FundingType;
import com.ryf.appbackend.jpa.entities.enums.Region;
import com.ryf.appbackend.models.dto.Opportunities;
import com.ryf.appbackend.core.repository.OpportunityRepository;
import com.ryf.appbackend.jpa.entities.OpportunityEntity;
import com.ryf.appbackend.jpa.entities.enums.FundinType;
import com.ryf.appbackend.models.dto.Opportunity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        List<OpportunityEntity> featured = opportunityRepository.getFeaturedOpportunitiesByPageAndSize(page, size);
        opportunities.setFeatured(opportunityUtil.getOpportunityFromEntityList(featured));

        List<OpportunityEntity> onlineCourses = opportunityRepository.getOpportunitiesByPageAndSize(FundinType.ONLINE_COURSES, page, size);
        opportunities.setOnlineCourses(opportunityUtil.getOpportunityFromEntityList(onlineCourses));

        List<OpportunityEntity> competitions = opportunityRepository.getOpportunitiesByPageAndSize(FundinType.COMPETITIONS, page, size);
        opportunities.setCompetitions(opportunityUtil.getOpportunityFromEntityList(competitions));

        List<OpportunityEntity> grants = opportunityRepository.getOpportunitiesByPageAndSize(FundinType.GRANTS, page, size);
        opportunities.setGrants(opportunityUtil.getOpportunityFromEntityList(grants));

//        List<OpportunityEntity> exchangePrograms = opportunityRepository.getOpportunitiesByPageAndSize(OpportunityType.EXCHANGE_PROGRAMS, page, size);
//        opportunities.setExchangePrograms(opportunityUtil.getOpportunityFromEntityList(exchangePrograms));

        opportunities.setExchangePrograms(opportunityUtil.getOpportunityFromEntityList(new ArrayList<>()));

        List<OpportunityEntity> internships = opportunityRepository.getOpportunitiesByPageAndSize(FundinType.INTERNSHIP, page, size);
        opportunities.setInternship(opportunityUtil.getOpportunityFromEntityList(internships));

        List<OpportunityEntity> fellowships = opportunityRepository.getOpportunitiesByPageAndSize(FundinType.FELLOWSHIPS, page, size);
        opportunities.setFellowships(opportunityUtil.getOpportunityFromEntityList(fellowships));

        List<OpportunityEntity> conferences = opportunityRepository.getOpportunitiesByPageAndSize(FundinType.CONFERENCES, page, size);
        opportunities.setConferences(opportunityUtil.getOpportunityFromEntityList(conferences));

//        List<OpportunityEntity> workshops = opportunityRepository.getOpportunitiesByPageAndSize(OpportunityType.WORKSHOPS, page, size);
//        opportunities.setWorkshops(opportunityUtil.getOpportunityFromEntityList(workshops));

        opportunities.setWorkshops(opportunityUtil.getOpportunityFromEntityList(new ArrayList<>()));

        List<OpportunityEntity> scholarships = opportunityRepository.getOpportunitiesByPageAndSize(FundinType.SCHOLARSHIPS, page, size);
        opportunities.setScholarships(opportunityUtil.getOpportunityFromEntityList(scholarships));

        List<OpportunityEntity> miscellaneous = opportunityRepository.getOpportunitiesByPageAndSize(FundinType.WORKSHOPS, FundinType.MISCELLANEOUS, page, size);
        opportunities.setMiscellaneous(opportunityUtil.getOpportunityFromEntityList(miscellaneous));

        return opportunities;

    }

    public List<Opportunity> recentPostsByDate(int page, int size){

        return opportunityUtil.getOpportunityFromEntityList(opportunityRepository.getlatestPost(page, size).toList());

    }


    public List<Opportunity> getoppotunitybyDeadline(String region,String type,int maxday, int minday) {

        if (type.equalsIgnoreCase("any") || region.equalsIgnoreCase("any")) {

            if (type.equalsIgnoreCase("any") && region.equalsIgnoreCase("any")) {
                return opportunityUtil.getoppotunitybyDeadline(opportunityRepository.getOpportunitybyDeadline(),maxday,minday);
            } else if (type.equalsIgnoreCase("any")) {
                return opportunityUtil.getoppotunitybyDeadline(opportunityRepository.findAllByRegion(Region.valueOf(region)),maxday,minday);
            } else {
                return opportunityUtil.getoppotunitybyDeadline(opportunityRepository.findAllByFundingType(FundingType.valueOf(type)),maxday,minday);

            }

        } else {
            return opportunityUtil.getoppotunitybyDeadline(opportunityRepository.findAllByFundingTypeAndRegion(FundingType.valueOf(type), Region.valueOf(region)),maxday,minday);
        }


       }
    }

