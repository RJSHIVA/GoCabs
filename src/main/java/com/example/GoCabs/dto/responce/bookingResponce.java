package com.example.GoCabs.dto.responce;

import com.example.GoCabs.Enum.Status;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class bookingResponce {

    private String pickup;
    private String destination;
    private Integer distance_in_km;
    private Status status;
    private double bill;
    Date created_at;
    Date updated_at;

    customerResponce customer;
    cabResponce cab;

}
