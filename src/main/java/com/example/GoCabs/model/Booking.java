package com.example.GoCabs.model;

import com.example.GoCabs.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pickup;
    private String destination;
    private Integer distance_in_km;
    private Status status;
    private double bill;

    @CreationTimestamp
    Date created_at;
    @UpdateTimestamp
    Date updated_at;

}
