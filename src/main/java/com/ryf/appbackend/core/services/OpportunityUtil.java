package com.ryf.appbackend.core.services;

import com.ryf.appbackend.core.opportunity.models.Opportunity;
import com.ryf.appbackend.jpa.entities.OpportunityEntity;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class OpportunityUtil {


    public List<Opportunity> getOpportunityFromEntityList(List<OpportunityEntity> opportunityEntityEntities) {
        return opportunityEntityEntities.stream().map(this::getOpportunityFromEntity).collect(Collectors.toList());
    }

    public Opportunity getOpportunityFromEntity(OpportunityEntity one) {

        Opportunity opportunity = new Opportunity();

        opportunity.setId(one.getId());
        opportunity.setTitle(one.getTitle());

        if (one.getDeadline() != null) {

            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            opportunity.setDeadlineString(simpleDateFormat.format(one.getDeadline()));


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
        } else {
            opportunity.setTimeLeft("Open");
            opportunity.setDeadline("Always Open");

        }


        opportunity.setRegion(one.getRegion().getName());
        opportunity.setFundingType(one.getFundingType().getName());
        opportunity.setOpportunityType(one.getOpportunityType().getName());

        opportunity.setRegionEnum(one.getRegion().toString());
        opportunity.setFundingTypeEnum(one.getFundingType().toString());
        opportunity.setOpportunityTypeEnum(one.getOpportunityType().toString());


        opportunity.setImage(ResourceUtil.imageEndpoint + "/" + one.getImage().getFile());
        opportunity.setDescription(one.getDescription());
        opportunity.setBenefit(one.getBenefit());
        opportunity.setEligibility(one.getEligibility());
        opportunity.setApplication_process(one.getApplication_process());
        opportunity.setOther(one.getOther());

        opportunity.setUrl(one.getUrl());

        opportunity.setApply_url(one.getApplyUrl());

        opportunity.setFeatured(one.getFeatured());

        return opportunity;
    }


}
