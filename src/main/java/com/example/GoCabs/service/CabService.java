package com.example.GoCabs.service;

import com.example.GoCabs.dto.request.cabRequest;
import com.example.GoCabs.dto.responce.cabResponce;
import com.example.GoCabs.exceptions.driverNotFoundException;
import com.example.GoCabs.model.Cab;
import com.example.GoCabs.model.Driver;
import com.example.GoCabs.repository.CabRepository;
import com.example.GoCabs.repository.DriverRepository;
import com.example.GoCabs.transformer.cabTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CabService {

    @Autowired
    private DriverRepository driverRepository;


    public cabResponce registerCab(cabRequest cabRequest, int driverId) {

        Optional<Driver> OptionalDriver = driverRepository.findById(driverId);
        if(OptionalDriver.isEmpty()) {
            throw new driverNotFoundException("Driver not found");
        }
        Driver driver = OptionalDriver.get();

        Cab cab  = cabTransformer.cabRequestTocab(cabRequest);

        driver.setCab(cab);

        Driver savedDriver = driverRepository.save(driver);

        return cabTransformer.cabToCabResponce(savedDriver.getCab(), savedDriver);

    }
}
