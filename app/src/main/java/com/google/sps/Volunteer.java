package com.google.sps;

public final class Volunteer {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final String birthday;
    private final String degree;
    private final String experience;
    private final String reference;


    public Volunteer(String firstName, String lastName, String email, String phone, String birthday, String degree, String experience, String reference) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.degree = degree;
        this.experience = experience;
        this.reference = reference;
    }
}