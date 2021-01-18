package com.ryf.appbackend.jpa.entities.enums;


public enum FundinType {

    ONLINE_COURSES("Online Course"),
    COMPETITIONS("Competition"),
    CONFERENCES("Conference"),
    //    EXCHANGE_PROGRAMS("Exchange Program"),
    INTERNSHIP("Internship"),
    FELLOWSHIPS("Fellowship"),
    GRANTS("Grants"),
    WORKSHOPS("Workshop"),
    MISCELLANEOUS("Miscellaneous"),
    SCHOLARSHIPS("Scholarship");

    private String name;

    FundinType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
