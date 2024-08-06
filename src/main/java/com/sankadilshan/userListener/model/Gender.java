package com.sankadilshan.userListener.model;

public enum Gender {
    MALE("Male"), FEMALE("Female");

    private String value;

    private Gender(String gender) {
        this.value = gender;
    }

    public String getValue() {
        return this.value;
    }
}
