package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.demo.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Optional<Customer> findByName(String nameCustomer);
}
