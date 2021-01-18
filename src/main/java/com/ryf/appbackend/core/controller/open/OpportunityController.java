package com.ryf.appbackend.core.controller.open;

import com.ryf.appbackend.models.dto.Category;
import com.ryf.appbackend.models.dto.Opportunities;
import com.ryf.appbackend.models.dto.Opportunity;
import com.ryf.appbackend.core.repository.OpportunityRepository;
import com.ryf.appbackend.core.services.OpportunityService;
import com.ryf.appbackend.core.services.OpportunityUtil;
import com.ryf.appbackend.jpa.dao.OpportunityDao;
import com.ryf.appbackend.jpa.entities.enums.OpportunityType;
import com.ryf.appbackend.jpa.entities.enums.Region;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@CrossOrigin("*")
@RestController
public class OpportunityController {
    private final OpportunityDao opportunityDao;
    private OpportunityUtil opportunityUtil;
    private OpportunityRepository opportunityRepository;
    private OpportunityService opportunityService;

    public OpportunityController(
            OpportunityDao opportunityDao,
            OpportunityUtil opportunityUtil,
            OpportunityRepository opportunityRepository,
            OpportunityService opportunityService
    ) {
        this.opportunityDao = opportunityDao;
        this.opportunityUtil = opportunityUtil;
        this.opportunityRepository = opportunityRepository;
        this.opportunityService = opportunityService;
    }


    @RequestMapping(path = "/v1/public/opportunity")
    @ResponseBody
    public Opportunity opportunity(@RequestParam("id") Long id) {
        return opportunityUtil.getOpportunityFromEntity(opportunityDao.getOne(id));
    }

    @RequestMapping(path = "/v1/public/opportunities")
    @ResponseBody
    public Opportunities opportunityList() {
        return opportunityService.getOpportunitiesForHome();
    }

    /*
     *
     * PRIORITIZED (featured, search & type)
     *
     * */
    @RequestMapping(path = "/v1/public/opportunities/featured")
    @ResponseBody
    public List<Opportunity> featuredOpportunityList(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size

    ) {

        return opportunityUtil.getOpportunityFromEntityList(opportunityRepository.getFeaturedOpportunitiesByPageAndSize(page, size));
    }

    @RequestMapping(path = "/v1/public/opportunities/search")
    @ResponseBody
    public List<Opportunity> searchByTitlePageAndSize(
            @RequestParam("query") String query,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size

    ) {
        if (query.length() < 4) {
            return new ArrayList<>();
        }
        return opportunityUtil.getOpportunityFromEntityList(opportunityRepository.searchByTitlePageAndSize(query, page, size));
    }

    @RequestMapping(path = "/v1/public/opportunities/{type}")
    @ResponseBody
    public List<Opportunity> opportunityList(
            @PathVariable OpportunityType type,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size

    ) {

        if (type == OpportunityType.WORKSHOPS || type == OpportunityType.MISCELLANEOUS) {
            return opportunityUtil.getOpportunityFromEntityList(opportunityRepository.getOpportunitiesByPageAndSize(OpportunityType.WORKSHOPS, OpportunityType.MISCELLANEOUS, page, size));

        }

        return opportunityUtil.getOpportunityFromEntityList(opportunityRepository.getOpportunitiesByPageAndSize(type, page, size));
    }

    /*
     *
     *
     *
     * */


    @RequestMapping(path = "/v1/public/opportunities/{type}/{region}")
    @ResponseBody
    public List<Opportunity> opportunityByTypeAndRegion(
            @PathVariable String region,
            @PathVariable String type,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size

    ) {


        if (type.equalsIgnoreCase("any") || region.equalsIgnoreCase("any")) {

            if (type.equalsIgnoreCase("any") && region.equalsIgnoreCase("any")) {
                return opportunityUtil.getOpportunityFromEntityList(opportunityRepository.findAll(page, size));
            } else if (type.equalsIgnoreCase("any")) {
                return opportunityUtil.getOpportunityFromEntityList(opportunityRepository.findAllByRegion(Region.valueOf(region), page, size));
            } else {
                return opportunityUtil.getOpportunityFromEntityList(opportunityRepository.findAllByOpportunityType(OpportunityType.valueOf(type), page, size));

            }

        } else {
            return opportunityUtil.getOpportunityFromEntityList(opportunityRepository.findAllByOpportunityTypeAndRegion(OpportunityType.valueOf(type), Region.valueOf(region), page, size));
        }
    }

    @RequestMapping(path = "/v1/public/categories")
    @ResponseBody
    public List<Category> categories() {
        Category category = new Category(OpportunityType.MISCELLANEOUS, "categoryimages/workshop.png");
        category.setTitle("Workshop");
        return Arrays.asList(

                new Category(OpportunityType.COMPETITIONS, "categoryimages/competitions.png"),
                new Category(OpportunityType.CONFERENCES, "categoryimages/conference.png"),
//                new Category(OpportunityType.EXCHANGE_PROGRAMS, "categoryimages/exchange-program.png"),
                new Category(OpportunityType.INTERNSHIP, "categoryimages/internship.png"),
                new Category(OpportunityType.FELLOWSHIPS, "categoryimages/fellowship.png"),
                new Category(OpportunityType.GRANTS, "categoryimages/grant.png"),
                new Category(OpportunityType.SCHOLARSHIPS, "categoryimages/scholarship.png"),
                category,
                new Category(OpportunityType.MISCELLANEOUS, "categoryimages/miscellaneous.png")

        );
    }

    @GetMapping(path="/v1/public/recentPosts")
    public List<Opportunity> recentOpportunitybyDate(@RequestParam(value = "page",required = false,defaultValue = "0") int page,
                                                     @RequestParam(value = "size",required = false,defaultValue = "8") int size
    ){

        return opportunityService.recentPostsByDate(page, size);
    }

    @GetMapping("/v1/public/filter/deadlines")
    public List<Opportunity> getoppotunitybyDeadline(@RequestParam(value = "maxday",required = true) int maxday,
                                                     @RequestParam(value = "minday",required = true) int minday){

            return opportunityService.getoppotunitybyDeadline(maxday,minday);
    }

}
