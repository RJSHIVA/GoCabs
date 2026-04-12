package com.example.GoCabs.repository;

import com.example.GoCabs.Enum.Gender;
import com.example.GoCabs.dto.responce.customerResponce;
import com.example.GoCabs.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    public List<Customer> findByGender(Gender gender);

}
