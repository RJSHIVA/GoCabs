package com.example.GoCabs.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(unique = true , nullable = false)
    private String email;
    private Integer age;

    @OneToMany(cascade = CascadeType.ALL)
            @JoinColumn(name = "driver_id")
    List<Booking> bookings = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
            @JoinColumn(name="cab_id")
    Cab cab;
}
