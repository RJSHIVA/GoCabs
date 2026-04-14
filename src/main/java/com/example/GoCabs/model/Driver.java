package com.example.GoCabs.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

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
    private String email;
    private Integer age;

    @OneToMany(cascade = CascadeType.ALL)
            @JoinColumn(name = "driver_id")
    ArrayList<Booking> bookings = new ArrayList<>();
}
