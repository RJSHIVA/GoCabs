package com.example.GoCabs.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Gender {
    MALE, FEMALE, OTHER;

    @JsonCreator
    public static Gender fromValue(String value) {
        return Gender.valueOf(value.toUpperCase());
    }
}