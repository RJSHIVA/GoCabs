package com.example.GoCabs.model;

import com.example.GoCabs.Enum.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pickup;
    private String destination;
    private Integer distance_in_km;
    private double bill;

    @Enumerated(EnumType.STRING)
    private Status status;

    // ✅ Add karo - Customer relation
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // ✅ Add karo - Cab relation
    @ManyToOne
    @JoinColumn(name = "cab_id")
    private Cab cab;

    @CreationTimestamp
    Date created_at;
    @UpdateTimestamp
    Date updated_at;
}