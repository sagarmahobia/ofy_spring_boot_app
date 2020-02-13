package com.ryf.appbackend.core.opportunity.models;

import com.ryf.appbackend.jpa.entities.enums.FundingType;
import com.ryf.appbackend.jpa.entities.enums.OpportunityType;
import com.ryf.appbackend.jpa.entities.enums.Region;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;


@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
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


}
