package com.example.GoCabs.transformer;

import com.example.GoCabs.dto.request.driverRequest;
import com.example.GoCabs.dto.responce.driverResponce;
import com.example.GoCabs.model.Driver;

public class driverTransformer {

    public static Driver driverRequestToDriver(driverRequest driverRequest){
        return Driver.builder()
                .age(driverRequest.getAge())
                .name(driverRequest.getName())
                .email(driverRequest.getEmail())
                .build();
    }

    public static driverResponce driverToDriverResponce(Driver driver){
        return driverResponce.builder()
                .name(driver.getName())
                .email(driver.getEmail())
                .age(driver.getAge())
                .build();
    }
}
