package com.example.GoCabs.repository;

import com.example.GoCabs.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer> {

    // ✅ LIMIT 1 - sirf ek cab return karega
    @Query(value = "SELECT * FROM cab WHERE available = true ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Cab getAvailableCab();
}