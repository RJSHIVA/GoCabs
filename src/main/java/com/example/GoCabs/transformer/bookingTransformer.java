package com.example.GoCabs.transformer;

import com.example.GoCabs.Enum.Status;
import com.example.GoCabs.dto.request.bookingRequest;
import com.example.GoCabs.dto.responce.bookingResponce;
import com.example.GoCabs.model.Booking;
import com.example.GoCabs.model.Cab;
import com.example.GoCabs.model.Customer;
import com.example.GoCabs.model.Driver;

public class bookingTransformer {

    public static Booking bookingRequestToBooking(bookingRequest bookingRequest,int perKmRate){

        return  Booking.builder()
                .bill(bookingRequest.getDistance_in_km()*perKmRate)
                .destination(bookingRequest.getDestination())
                .distance_in_km(bookingRequest.getDistance_in_km())
                .pickup(bookingRequest.getPickup())
                .status(Status.ONGOING)
                .build();
    }

    public static bookingResponce bookingToBookingResponse(Booking booking, Customer customer, Cab cab, Driver driver){
        return bookingResponce.builder()
                .updated_at(booking.getUpdated_at())
                .destination(booking.getDestination())
                .distance_in_km(booking.getDistance_in_km())
                .pickup(booking.getPickup())
                .status(booking.getStatus())
                .customer(customerTransformer.customerToCustomerResponce(customer))
                .cab(cabTransformer.cabToCabResponce(cab,driver))
                .bill(booking.getBill())
                .build();
    }
}
