package com.example.GoCabs.service;

import com.example.GoCabs.dto.request.driverRequest;
import com.example.GoCabs.dto.responce.driverResponce;
import com.example.GoCabs.model.Driver;
import com.example.GoCabs.repository.DriverRepository;
import com.example.GoCabs.transformer.driverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public driverResponce save(driverRequest driverrequest) {
        Driver driver = driverTransformer.driverRequestToDriver(driverrequest);
        Driver savedDriver = driverRepository.save(driver);
        return driverTransformer.driverToDriverResponce(savedDriver);
    }
}