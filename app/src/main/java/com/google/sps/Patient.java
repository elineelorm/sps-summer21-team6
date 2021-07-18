package com.google.sps;

import java.util.ArrayList; 

public final class Patient {

    private final String name;
    private final int age;
    private String symptoms;


    public Patient(String name, int age, String symptom) {
       this.name = name;
       this.age = age;
       this.symptoms = symptom;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getSymptoms () {
        return this.symptoms;
    }
}