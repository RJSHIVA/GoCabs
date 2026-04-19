package com.example.GoCabs.dto.responce;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class cabResponce {
    private int cab_number;
    private String cab_model;
    private double per_km_rate;
    private boolean available;
    private driverResponce driverResponce;
}
