package com.google.sps;

public final class Volunteer {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String experience;
    private final String reference;
    private final String id;


    public Volunteer(String firstName, String lastName, String email, String experience, String reference) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.experience = experience;
        this.reference = reference;
        this.id = firstName + lastName;
    }

    public Volunteer() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.experience = "";
        this.reference = "";
        this.id = "";
    }

    public String getId(){
        return this.id;
    }
}