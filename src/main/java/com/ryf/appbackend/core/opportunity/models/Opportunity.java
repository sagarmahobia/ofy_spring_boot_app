package com.ryf.appbackend.core.opportunity.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
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

    private String apply_url;

    private boolean featured;

}
