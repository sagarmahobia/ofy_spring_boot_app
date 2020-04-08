package com.ryf.appbackend.jpa.entities.enums;

public enum FundingType {

    NONE("None"), FullyFunded("Fully Funded"), PartiallyFunded("Partially Funded"), SelfFunded("Self Funded"), PAID("Paid"), UNPAID("Unpaid");

    private String name;

    FundingType(String fundingType) {
        this.name = fundingType;
    }

    public String getName() {
        return name;
    }

}
