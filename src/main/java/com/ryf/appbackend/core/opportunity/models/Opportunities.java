package com.ryf.appbackend.core.opportunity.models;

import java.util.List;

public class Opportunities {

    private List<Opportunity> competitions;
    private List<Opportunity> conferences;
    private List<Opportunity> exchangePrograms;
    private List<Opportunity> fellowships;
        private List<Opportunity> internship;
    private List<Opportunity> scholarships;
    private List<Opportunity> workshops;
    private List<Opportunity> grants;
    private List<Opportunity> miscellaneous;


    public List<Opportunity> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Opportunity> competitions) {
        this.competitions = competitions;
    }

    public List<Opportunity> getConferences() {
        return conferences;
    }

    public void setConferences(List<Opportunity> conferences) {
        this.conferences = conferences;
    }

    public List<Opportunity> getExchangePrograms() {
        return exchangePrograms;
    }

    public void setExchangePrograms(List<Opportunity> exchangePrograms) {
        this.exchangePrograms = exchangePrograms;
    }

    public List<Opportunity> getFellowships() {
        return fellowships;
    }

    public void setFellowships(List<Opportunity> fellowships) {
        this.fellowships = fellowships;
    }

    public List<Opportunity> getInternship() {
        return internship;
    }

    public void setInternship(List<Opportunity> internship) {
        this.internship = internship;
    }

    public List<Opportunity> getMiscellaneous() {
        return miscellaneous;
    }

    public void setMiscellaneous(List<Opportunity> miscellaneous) {
        this.miscellaneous = miscellaneous;
    }

    public List<Opportunity> getScholarships() {
        return scholarships;
    }

    public void setScholarships(List<Opportunity> scholarships) {
        this.scholarships = scholarships;
    }

    public List<Opportunity> getWorkshops() {
        return workshops;
    }

    public void setWorkshops(List<Opportunity> workshops) {
        this.workshops = workshops;
    }

    public void setGrants(List<Opportunity> grants) {
        this.grants = grants;
    }

    public List<Opportunity> getGrants() {
        return grants;
    }
}
