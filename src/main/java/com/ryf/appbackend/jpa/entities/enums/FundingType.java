package com.ryf.appbackend.jpa.entities.enums;

public enum FundingType {

    FullyFunded("Fully Funded"), PartiallyFunded("Partially Funded"), SelfFunded("Self Funded");

    private String name;

    FundingType(String fundingType) {
        this.name = fundingType;
    }

    public String getName() {
        return name;
    }

}
