package com.ryf.appbackend.jpa.entities;


import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Opportunities")
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @OneToOne
    @JoinColumn(name = "opportunity_type_id")
    private OpportunityType opportunityType;

    @OneToOne
    @JoinColumn(name = "funding_type_id")
    private FundingType fundingType;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @OneToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @Column(name = "date")
    private Date deadline;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
