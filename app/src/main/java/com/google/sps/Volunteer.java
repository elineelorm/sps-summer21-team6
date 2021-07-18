package com.google.sps;

import java.util.UUID;

public final class Volunteer {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String experience;
    private final String reference;
    private final String ID;


    public Volunteer(String firstName, String lastName, String email, String experience, String reference) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.experience = experience;
        this.reference = reference;
        this.ID = UUID.randomUUID().toString();
    }

    public Volunteer() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.experience = "";
        this.reference = "";
        this.ID = "";
    }
}