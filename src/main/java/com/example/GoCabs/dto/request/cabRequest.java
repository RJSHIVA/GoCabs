package com.example.GoCabs.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class cabRequest {
    private int cab_number;
    private String cab_model;
    private double per_km_rate;
}
