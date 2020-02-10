package com.ryf.appbackend.jpa.entities.enums;


public enum OpportunityType {

    COMPETITIONS("Competition"),
    CONFERENCES("Conference"),
    EXCHANGE_PROGRAMS("Exchange Program"),
    FELLOWSHIPS("Fellowship"),
    GRANTS("Grants"),
    WORKSHOPS("Workshop"),
    MISCELLANEOUS("Miscellaneous"),
    SCHOLARSHIPS("Scholarship");

    //    INTERNSHIP("Internship"),


    private String name;

    OpportunityType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
