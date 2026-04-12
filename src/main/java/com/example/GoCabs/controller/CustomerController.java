package com.example.GoCabs.controller;

import com.example.GoCabs.Enum.Gender;
import com.example.GoCabs.dto.request.customerRequest;
import com.example.GoCabs.dto.responce.customerResponce;
import com.example.GoCabs.model.Customer;
import com.example.GoCabs.service.CustomerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customer")
public class CustomerController {

   @Autowired
   CustomerService customerService;

   @PostMapping("/add")
   public customerResponce addCustomer(@RequestBody customerRequest customerRequest) {

         customerResponce  saved = customerService.addCustomer(customerRequest);
         return saved;
   }
   
   @GetMapping("get/customer-id/{id}")
   public Customer getCustomer(@PathVariable("id") Integer id){
      return customerService.getCustomer(id);
   }

   @GetMapping("get/gender/{gender}")
   public List<customerResponce> getGender(@PathVariable("gender") Gender gender){

      return customerService.getbygender(gender);
   }

}
