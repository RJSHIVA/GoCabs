package com.example.GoCabs.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class bookingRequest {
    private String pickup;
    private String destination;
    private Integer distance_in_km;
}
