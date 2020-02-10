package com.ryf.appbackend.controller.opportunity;


import com.ryf.appbackend.controller.opportunity.models.Category;
import com.ryf.appbackend.controller.opportunity.models.Opportunities;
import com.ryf.appbackend.controller.opportunity.models.Opportunity;
import com.ryf.appbackend.jpa.dao.OpportunityDao;
import com.ryf.appbackend.jpa.entities.OpportunityEntity;
import com.ryf.appbackend.jpa.entities.enums.OpportunityType;
import com.ryf.appbackend.jpa.entities.enums.Region;
import com.ryf.appbackend.services.OpportunityUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@CrossOrigin("*")
@RestController
public class OpportunityController {
    private final OpportunityDao opportunityDao;
    private OpportunityUtil opportunityUtil;

    public OpportunityController(OpportunityDao opportunityDao, OpportunityUtil opportunityUtil) {
        this.opportunityDao = opportunityDao;
        this.opportunityUtil = opportunityUtil;
    }


    @RequestMapping(path = "/api/v1/public/opportunity")
    @ResponseBody
    public Opportunity opportunity(@RequestParam("id") Long id) {
        return opportunityUtil.getOpportunityFromEntity(opportunityDao.getOne(id));
    }

    @RequestMapping(path = "/api/v1/public/opportunities")
    @ResponseBody
    public Opportunities opportunityList() {

        Opportunities opportunities = new Opportunities();

        List<OpportunityEntity> competitions = opportunityDao.findAllByOpportunityType(OpportunityType.COMPETITIONS);
        opportunities.setCompetitions(opportunityUtil.getOpportunityFromEntityList(competitions));

        List<OpportunityEntity> grants = opportunityDao.findAllByOpportunityType(OpportunityType.GRANTS);
        opportunities.setGrants(opportunityUtil.getOpportunityFromEntityList(grants));

        List<OpportunityEntity> exchangePrograms = opportunityDao.findAllByOpportunityType(OpportunityType.EXCHANGE_PROGRAMS);
        opportunities.setExchangePrograms(opportunityUtil.getOpportunityFromEntityList(exchangePrograms));

        List<OpportunityEntity> fellowships = opportunityDao.findAllByOpportunityType(OpportunityType.FELLOWSHIPS);
        opportunities.setFellowships(opportunityUtil.getOpportunityFromEntityList(fellowships));

        List<OpportunityEntity> conferences = opportunityDao.findAllByOpportunityType(OpportunityType.CONFERENCES);
        opportunities.setConferences(opportunityUtil.getOpportunityFromEntityList(conferences));

        List<OpportunityEntity> workshops = opportunityDao.findAllByOpportunityType(OpportunityType.WORKSHOPS);
        opportunities.setWorkshops(opportunityUtil.getOpportunityFromEntityList(workshops));

        List<OpportunityEntity> scholarships = opportunityDao.findAllByOpportunityType(OpportunityType.SCHOLARSHIPS);
        opportunities.setScholarships(opportunityUtil.getOpportunityFromEntityList(scholarships));

        List<OpportunityEntity> miscellaneous = opportunityDao.findAllByOpportunityType(OpportunityType.MISCELLANEOUS);
        opportunities.setMiscellaneous(opportunityUtil.getOpportunityFromEntityList(miscellaneous));

        return opportunities;

    }

    @RequestMapping(path = "/api/v1/public/opportunities/{type}")
    @ResponseBody
    public List<Opportunity> opportunityList(@PathVariable OpportunityType type) {
        return opportunityUtil.getOpportunityFromEntityList(opportunityDao.findAllByOpportunityType(type));
    }


    @RequestMapping(path = "/api/v1/public/categories")
    @ResponseBody
    public List<Category> categories() {
        return Arrays.asList(

                new Category(OpportunityType.COMPETITIONS, "categoryimages/competition.png"),
                new Category(OpportunityType.CONFERENCES, "categoryimages/conference.png"),
                new Category(OpportunityType.EXCHANGE_PROGRAMS, "categoryimages/exchange-program.png"),
                new Category(OpportunityType.FELLOWSHIPS, "categoryimages/fellowship.png"),
                new Category(OpportunityType.GRANTS, "categoryimages/grant.png"),
                new Category(OpportunityType.SCHOLARSHIPS, "categoryimages/scholarship.png"),
                new Category(OpportunityType.WORKSHOPS, "categoryimages/workshop.png"),
                new Category(OpportunityType.MISCELLANEOUS, "categoryimages/workshop.png")

        );
    }


    @RequestMapping(path = "/api/v1/public/opportunities/{type}/{region}")
    @ResponseBody
    public List<Opportunity> opportunityFilter(@PathVariable String region, @PathVariable String type) {
        if (type.equalsIgnoreCase("any") || region.equalsIgnoreCase("any")) {

            if (type.equalsIgnoreCase("any") && region.equalsIgnoreCase("any")) {
                return opportunityUtil.getOpportunityFromEntityList(opportunityDao.findAll());
            } else if (type.equalsIgnoreCase("any")) {
                return opportunityUtil.getOpportunityFromEntityList(opportunityDao.findAllByRegion(Region.valueOf(region)));
            } else {
                return opportunityUtil.getOpportunityFromEntityList(opportunityDao.findAllByOpportunityType(OpportunityType.valueOf(type)));

            }

        } else {
            return opportunityUtil.getOpportunityFromEntityList(opportunityDao.findAllByOpportunityTypeAndRegion(OpportunityType.valueOf(type), Region.valueOf(region)));
        }
    }


}
