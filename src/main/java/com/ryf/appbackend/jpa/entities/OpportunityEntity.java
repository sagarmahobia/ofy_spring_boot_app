package com.ryf.appbackend.jpa.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ryf.appbackend.jpa.entities.enums.FundingType;
import com.ryf.appbackend.jpa.entities.enums.OpportunityType;
import com.ryf.appbackend.jpa.entities.enums.Region;
import com.ryf.appbackend.jpa.entities.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Opportunities")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OpportunityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Enumerated(EnumType.STRING)
    private OpportunityType opportunityType;

    @Enumerated(EnumType.STRING)
    private FundingType fundingType;

    @Enumerated(EnumType.STRING)
    private Region region;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;

    @Column(name = "date")
    private Date deadline;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "benefit", columnDefinition = "TEXT")
    private String benefit;

    @Column(name = "eligibility", columnDefinition = "TEXT")
    private String eligibility;

    @Column(name = "application_process", columnDefinition = "TEXT")
    private String application_process;

    @Column(name = "other", columnDefinition = "TEXT")
    private String other;

    @Column(name = "url")
    private String url;

    @Column(name = "apply_url")
    private String applyUrl;

    @Column(name = "featured", columnDefinition = "boolean default false")
    private Boolean featured;


    @Column(name = "ordering",nullable = false,columnDefinition = "int(11) default 0")
    private Integer ordering;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {

        if (featured == null) {
            this.featured = false;
        } else {
            this.featured = featured;
        }
    }
}
