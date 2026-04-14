package com.example.GoCabs.repository;

import com.example.GoCabs.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {


}
