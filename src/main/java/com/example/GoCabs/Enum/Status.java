package com.example.GoCabs.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Status {
    ONGOING,
    COMPLETED,
    CANCELLED;

    @JsonCreator
    public static Status fromValue(String value) {
        return Status.valueOf(value.toUpperCase());
    }
}