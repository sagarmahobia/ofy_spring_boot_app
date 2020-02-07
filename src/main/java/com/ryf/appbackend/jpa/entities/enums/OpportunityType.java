package com.ryf.appbackend.jpa.entities.enums;


public enum OpportunityType {

    COMPETITIONS("Competition"),
    CONFERENCES("Conference"),
    EXCHANGE_PROGRAMS("Exchange Program"),
    FELLOWSHIPS("Fellowship"),
    GRANTS("Grants"),
    INTERNSHIP("Internship"),
    SCHOLARSHIPS("Scholarship"),
    WORKSHOPS("Workshop");

    private String name;

    OpportunityType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
