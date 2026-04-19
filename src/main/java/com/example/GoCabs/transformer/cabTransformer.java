package com.example.GoCabs.transformer;

import com.example.GoCabs.dto.request.cabRequest;
import com.example.GoCabs.dto.responce.cabResponce;

import com.example.GoCabs.model.Cab;
import com.example.GoCabs.model.Driver;

public class cabTransformer {

    public static Cab cabRequestTocab(cabRequest cabRequest){
        return Cab.builder()
                .cab_number(cabRequest.getCab_number())
                .cab_model(cabRequest.getCab_model())
                .per_km_rate(cabRequest.getPer_km_rate())
                .available(true)
                .build();
    }

    public static cabResponce  cabToCabResponce(Cab cab, Driver driver){
        return cabResponce.builder()
                .driverResponce(driverTransformer.driverToDriverResponce(driver))
                .per_km_rate( cab.getPer_km_rate())
                .available(cab.isAvailable())
                .cab_model(cab.getCab_model())
                .cab_number(cab.getCab_number())
                .build();
    }
}
