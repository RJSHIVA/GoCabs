package com.example.GoCabs.controller;

import com.example.GoCabs.dto.request.driverRequest;
import com.example.GoCabs.dto.responce.driverResponce;
import com.example.GoCabs.model.Driver;
import com.example.GoCabs.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/add")
    public driverResponce addDriver(@RequestBody driverRequest driverRequest) {
        return driverService.save(driverRequest);
    }



}
