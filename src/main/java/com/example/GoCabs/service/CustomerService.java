package com.example.GoCabs.service;

import com.example.GoCabs.Enum.Gender;
import com.example.GoCabs.dto.request.customerRequest;
import com.example.GoCabs.dto.responce.customerResponce;
import com.example.GoCabs.exceptions.CustomerNotFoundException;
import com.example.GoCabs.model.Customer;
import com.example.GoCabs.repository.CustomerRepository;
import com.example.GoCabs.transformer.customerTransformer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public customerResponce addCustomer(customerRequest customerRequest) {
        // ✅ Use transformer instead of manually setting fields
        Customer customer = customerTransformer.customerRequestToCustomer(customerRequest);
        Customer savedCustomer = customerRepository.save(customer); // save() returns Customer
        return customerTransformer.customerToCustomerResponce(savedCustomer); // ✅ Convert before returning
    }

    public Customer getCustomer(Integer customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Customer Not Found");
        }
        return optionalCustomer.get();
    }

    public List<customerResponce> getbygender(Gender gender) {

        List<Customer> customerList = customerRepository.findByGender(gender);

        List<customerResponce> customerResponceList = new ArrayList<>();
        for(Customer customer : customerList){
            customerResponceList.add(customerTransformer.customerToCustomerResponce(customer));
        }
        return customerResponceList;

    }
}