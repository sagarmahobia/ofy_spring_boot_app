package com.ryf.appbackend.controller.opportunity.models;

import com.ryf.appbackend.jpa.entities.enums.OpportunityType;

public class Category {

    private String id;

    private String title;

    private String image;

    private OpportunityType opportunityType;


    public Category(OpportunityType type, String image) {
        this.opportunityType = type;
        this.id = type.toString();
        this.title = type.getName();
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OpportunityType getOpportunityType() {
        return opportunityType;
    }

    public void setOpportunityType(OpportunityType opportunityType) {
        this.opportunityType = opportunityType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
