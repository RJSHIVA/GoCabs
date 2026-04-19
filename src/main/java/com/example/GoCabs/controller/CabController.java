package com.example.GoCabs.controller;


import com.example.GoCabs.dto.request.cabRequest;
import com.example.GoCabs.dto.responce.cabResponce;
import com.example.GoCabs.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cab")
public class CabController {

    @Autowired
    private CabService cabService;
    @PostMapping("/register/driver/{driverId}")
    public cabResponce registerCab( @RequestBody cabRequest cabRequest,
                                    @PathVariable("driverId") int driverId ) {

        return cabService.registerCab(cabRequest,driverId);


    }
}
