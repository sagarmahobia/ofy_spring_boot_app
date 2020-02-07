package com.ryf.appbackend.controller.opportunity;


import com.ryf.appbackend.controller.opportunity.models.Category;
import com.ryf.appbackend.controller.opportunity.models.Opportunities;
import com.ryf.appbackend.controller.opportunity.models.Opportunity;
import com.ryf.appbackend.jpa.dao.OpportunityDao;
import com.ryf.appbackend.jpa.entities.OpportunityEntity;
import com.ryf.appbackend.jpa.entities.enums.OpportunityType;
import com.ryf.appbackend.jpa.entities.enums.Region;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


@CrossOrigin("*")
@RestController
public class OpportunityController {
    public static String imageEndpoint = "https://ofy-images.s3.ap-south-1.amazonaws.com";
    private final OpportunityDao opportunityDao;

    public OpportunityController(OpportunityDao opportunityDao) {
        this.opportunityDao = opportunityDao;
    }


    @RequestMapping(path = "/api/v1/public/opportunity")
    @ResponseBody
    public Opportunity opportunity(@RequestParam("id") Long id) {
        return getOpportunityFromEntity(opportunityDao.getOne(id));
    }

    @RequestMapping(path = "/api/v1/public/opportunities")
    @ResponseBody
    public Opportunities opportunityList() {

        Opportunities opportunities = new Opportunities();

        List<OpportunityEntity> competitions = opportunityDao.findAllByOpportunityType(OpportunityType.COMPETITIONS);
        opportunities.setCompetitions(getOpportunityFromEntityList(competitions));

        List<OpportunityEntity> grants = opportunityDao.findAllByOpportunityType(OpportunityType.GRANTS);
        opportunities.setGrants(getOpportunityFromEntityList(grants));

        List<OpportunityEntity> exchangePrograms = opportunityDao.findAllByOpportunityType(OpportunityType.EXCHANGE_PROGRAMS);
        opportunities.setExchangePrograms(getOpportunityFromEntityList(exchangePrograms));

        List<OpportunityEntity> fellowships = opportunityDao.findAllByOpportunityType(OpportunityType.FELLOWSHIPS);
        opportunities.setFellowships(getOpportunityFromEntityList(fellowships));

        List<OpportunityEntity> internship = opportunityDao.findAllByOpportunityType(OpportunityType.INTERNSHIP);
        opportunities.setInternship(getOpportunityFromEntityList(internship));

        List<OpportunityEntity> conferences = opportunityDao.findAllByOpportunityType(OpportunityType.CONFERENCES);
        opportunities.setConferences(getOpportunityFromEntityList(conferences));

        List<OpportunityEntity> workshops = opportunityDao.findAllByOpportunityType(OpportunityType.WORKSHOPS);
        opportunities.setWorkshops(getOpportunityFromEntityList(workshops));

        List<OpportunityEntity> scholarships = opportunityDao.findAllByOpportunityType(OpportunityType.SCHOLARSHIPS);
        opportunities.setScholarships(getOpportunityFromEntityList(scholarships));

        return opportunities;

    }

    @RequestMapping(path = "/api/v1/public/opportunities/{type}")
    @ResponseBody
    public List<Opportunity> opportunityList(@PathVariable OpportunityType type) {
        return getOpportunityFromEntityList(opportunityDao.findAllByOpportunityType(type));
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
                new Category(OpportunityType.WORKSHOPS, "categoryimages/workshop.png")
        );
    }


    @RequestMapping(path = "/api/v1/public/opportunities/{type}/{region}")
    @ResponseBody
    public List<Opportunity> opportunityFilter(@PathVariable String region, @PathVariable String type) {
        if (type.equalsIgnoreCase("any") || region.equalsIgnoreCase("any")) {

            if (type.equalsIgnoreCase("any") && region.equalsIgnoreCase("any")) {
                return getOpportunityFromEntityList(opportunityDao.findAll());
            } else if (type.equalsIgnoreCase("any")) {
                return getOpportunityFromEntityList(opportunityDao.findAllByRegion(Region.valueOf(region)));
            } else {
                return getOpportunityFromEntityList(opportunityDao.findAllByOpportunityType(OpportunityType.valueOf(type)));

            }

        } else {
            return getOpportunityFromEntityList(opportunityDao.findAllByOpportunityTypeAndRegion(OpportunityType.valueOf(type), Region.valueOf(region)));
        }
    }

    /*
     *
     *   SUPPORT METHODS
     *
     * */

    private static List<Opportunity> getOpportunityFromEntityList(List<OpportunityEntity> opportunityEntityEntities) {
        return opportunityEntityEntities.stream().map(OpportunityController::getOpportunityFromEntity).collect(Collectors.toList());
    }

    private static Opportunity getOpportunityFromEntity(OpportunityEntity one) {

        Opportunity opportunity = new Opportunity();

        opportunity.setId(one.getId());
        opportunity.setTitle(one.getTitle());
        opportunity.setDeadline(one.getDeadline().toString());//todo to date

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);


        opportunity.setDeadlineString(simpleDateFormat.format(one.getDeadline()));


        opportunity.setRegion(one.getRegion().getName());
        opportunity.setFundingType(one.getFundingType().getName());
        opportunity.setOpportunityType(one.getOpportunityType().getName());

        opportunity.setRegionEnum(one.getRegion().toString());
        opportunity.setFundingTypeEnum(one.getFundingType().toString());
        opportunity.setOpportunityTypeEnum(one.getOpportunityType().toString());


        opportunity.setImage(imageEndpoint + "/" + one.getImage().getFile());
        opportunity.setDescription(one.getDescription());
        opportunity.setBenefit(one.getBenefit());
        opportunity.setEligibility(one.getEligibility());
        opportunity.setApplication_process(one.getApplication_process());
        opportunity.setOther(one.getOther());

        opportunity.setUrl(one.getUrl());

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = format.format(one.getDeadline());

        opportunity.setDeadline(dateString);

        //calculate difference
        long diffInMillies = one.getDeadline().getTime() - (new Date().getTime());
        if (diffInMillies > 0) {
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            //format date
            opportunity.setTimeLeft(String.format("%d Days Left", diff));
        } else {
            opportunity.setTimeLeft("Ended");
        }


        return opportunity;
    }


}
