package com.ryf.appbackend.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
 public class Opportunities {

    private List<Opportunity> featured;
    private List<Opportunity> competitions;
    private List<Opportunity> conferences;
    private List<Opportunity> exchangePrograms;
    private List<Opportunity> fellowships;
    private List<Opportunity> internship;
    private List<Opportunity> scholarships;
    private List<Opportunity> workshops;
    private List<Opportunity> grants;
    private List<Opportunity> miscellaneous;

}
