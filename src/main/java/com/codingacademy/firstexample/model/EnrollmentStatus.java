package com.codingacademy.firstexample.model;

public enum EnrollmentStatus {
    PENDING("Pending"),
    ACCEPTED("Accepted"),
    REFUSED("Refused");

    private final String status;

    EnrollmentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
