package com.example.bankservice.customers.repository;

import com.example.bankservice.customers.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;                                                       

@Repository
public interface CustomerResipository extends JpaRepository <Customer,Long> {

    Customer findByAccountNumber(String acccountnumber);
    Customer getCustomerById (Long id);


}
