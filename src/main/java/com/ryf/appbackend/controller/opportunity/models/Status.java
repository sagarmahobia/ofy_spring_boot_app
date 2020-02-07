package com.ryf.appbackend.controller.opportunity.models;

public class Status {

    public Status(String status) {
        this.status = status;
    }

    public Status() {
    }

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
