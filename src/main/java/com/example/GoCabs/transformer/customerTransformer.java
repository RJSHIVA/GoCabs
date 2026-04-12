package com.example.GoCabs.transformer;

import com.example.GoCabs.dto.request.customerRequest;
import com.example.GoCabs.dto.responce.customerResponce;
import com.example.GoCabs.model.Customer;

public class customerTransformer {

    // ✅ Accept customerRequest as a parameter
    public static Customer customerRequestToCustomer(customerRequest customerRequest) {
//        Customer customer = new Customer();
//        customer.setName(customerRequest.getName());
//        customer.setAge(customerRequest.getAge());
//        customer.setEmail(customerRequest.getEmail());
//        customer.setGender(customerRequest.getGender());
//        return customer;
        return Customer.builder()
                .age(customerRequest.getAge())
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .gender(customerRequest.getGender())
                .build();
    }

    // ✅ Accept Customer as a parameter + return the response object
    public static customerResponce customerToCustomerResponce(Customer customer) {
//        customerResponce response = new customerResponce();
//        response.setName(customer.getName());
//        response.setAge(customer.getAge());
//        response.setEmail(customer.getEmail());
//        return response; // ✅ Was missing return statement

        return customerResponce.builder()
                .name(customer.getName())
                .age(customer.getAge())
                .email(customer.getEmail()).build();
    }
}