package com.ryf.appbackend.core.opportunity.models;

public class Opportunity {

    private long id;

    private String title;

    private String opportunityType;

    private String fundingType;

    private String region;

    private String opportunityTypeEnum;

    private String fundingTypeEnum;

    private String regionEnum;

    private String image;

    private String deadline;

    private String deadlineString;

    private String timeLeft;

    private String description;

    private String benefit;

    private String eligibility;

    private String application_process;

    private String other;

    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOpportunityType() {
        return opportunityType;
    }

    public void setOpportunityType(String opportunityType) {
        this.opportunityType = opportunityType;
    }

    public String getFundingType() {
        return fundingType;
    }

    public void setFundingType(String fundingType) {
        this.fundingType = fundingType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }

    public String getDescription() {
        return description;
    }

    public String getDeadlineString() {
        return deadlineString;
    }

    public void setDeadlineString(String deadlineString) {
        this.deadlineString = deadlineString;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getApplication_process() {
        return application_process;
    }

    public void setApplication_process(String application_process) {
        this.application_process = application_process;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }


    public String getOpportunityTypeEnum() {
        return opportunityTypeEnum;
    }

    public void setOpportunityTypeEnum(String opportunityTypeEnum) {
        this.opportunityTypeEnum = opportunityTypeEnum;
    }

    public String getFundingTypeEnum() {
        return fundingTypeEnum;
    }

    public void setFundingTypeEnum(String fundingTypeEnum) {
        this.fundingTypeEnum = fundingTypeEnum;
    }

    public String getRegionEnum() {
        return regionEnum;
    }

    public void setRegionEnum(String regionEnum) {
        this.regionEnum = regionEnum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
