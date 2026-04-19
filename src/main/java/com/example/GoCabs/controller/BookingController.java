package com.example.GoCabs.controller;

import com.example.GoCabs.dto.request.bookingRequest;
import com.example.GoCabs.dto.responce.bookingResponce;
import com.example.GoCabs.repository.BookingRepository;
import com.example.GoCabs.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/book/customer/{customer_id}")
    public  bookingResponce  booking(@RequestBody bookingRequest bookingRequest,
                                    @PathVariable("customer_id") int customer_id){
        return bookingService.book(bookingRequest,customer_id);
    }
}
