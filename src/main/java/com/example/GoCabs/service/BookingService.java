package com.example.GoCabs.service;

import com.example.GoCabs.dto.request.bookingRequest;
import com.example.GoCabs.dto.responce.bookingResponce;
import com.example.GoCabs.exceptions.CustomerNotFoundException;
import com.example.GoCabs.exceptions.cabNotFoundException;
import com.example.GoCabs.model.Booking;
import com.example.GoCabs.model.Cab;
import com.example.GoCabs.model.Customer;
import com.example.GoCabs.model.Driver;
import com.example.GoCabs.repository.BookingRepository;
import com.example.GoCabs.repository.CabRepository;
import com.example.GoCabs.repository.CustomerRepository;
import com.example.GoCabs.repository.DriverRepository;
import com.example.GoCabs.transformer.bookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    CabRepository cabRepository;

    @Autowired
    BookingRepository bookingRepository;

    public  bookingResponce book(bookingRequest bookingRequest, int customerId) {

        Optional<Customer> OptionalCustomer  =  customerRepository.findById(customerId);
        if(OptionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Customer not found");
        }

        Customer customer = OptionalCustomer.get();

        Cab AvailableCab = cabRepository.getAvailableCab();

        if(AvailableCab==null){
            throw new cabNotFoundException("Sorry! cab not Available");
        }

        Booking savedBooking = bookingTransformer.bookingRequestToBooking(bookingRequest, (int) AvailableCab.getPer_km_rate());
        bookingRepository.save(savedBooking);

        AvailableCab.setAvailable(false);
        customer.getBookings().add(savedBooking);

        Driver driver = driverRepository.getBycabId(AvailableCab.getId());
        driver.getBookings().add(savedBooking);

        Customer savedCustomer = customerRepository.save(customer);
        Driver savedDriver = driverRepository.save(driver);

       return bookingTransformer.bookingToBookingResponse(savedBooking,savedCustomer,AvailableCab,savedDriver);

    }
}
