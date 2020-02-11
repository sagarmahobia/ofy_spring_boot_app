package com.ryf.appbackend.core.opportunity.models;

import com.ryf.appbackend.jpa.entities.enums.FundingType;
import com.ryf.appbackend.jpa.entities.enums.OpportunityType;
import com.ryf.appbackend.jpa.entities.enums.Region;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

public class OpportunityInput {

    private String title;
    private OpportunityType opportunityType;
    private FundingType fundingType;
    private Region region;
    private Date deadline;
    private MultipartFile image;
    private String eligibility;
    private String applicationProcess;
    private String benefit;
    private String other;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public OpportunityType getOpportunityType() {
        return opportunityType;
    }

    public void setOpportunityType(OpportunityType opportunityType) {
        this.opportunityType = opportunityType;
    }

    public FundingType getFundingType() {
        return fundingType;
    }

    public void setFundingType(FundingType fundingType) {
        this.fundingType = fundingType;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getApplicationProcess() {
        return applicationProcess;
    }

    public void setApplicationProcess(String applicationProcess) {
        this.applicationProcess = applicationProcess;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
