package com.example.bankservice.customers.service;
import com.example.bankservice.customers.dto.CreateCustomerRequest;
import com.example.bankservice.customers.dto.CreateCustomerResponse;
import com.example.bankservice.customers.model.Customer;
import com.example.bankservice.customers.repository.CustomerResipository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class Customerservices {

    @Autowired
    private final CustomerResipository customerResipository;



    /* Create User */
    public Customer CreateUser(CreateCustomerRequest customerRequest){
        Customer customer = Customer.builder()
                .firstName(customerRequest.getFirstName())
                .secondName(customerRequest.getSecondName())
                .email(customerRequest.getEmail())
                .username(customerRequest.getUsername())
                .Amount(customerRequest.getAmount())
                .password(customerRequest.getPassword())
                .build();
        customer.setBalance(customerRequest.getAmount());
        generateaccountnumber(customer);
        customerResipository.save(customer);
        log.info("Customer" + customer.getFirstName() + "is created");
        return customer;
    }

    //add money
    public Customer addmoney (Long id, Customer customer) {
        Optional<Customer> customers = customerResipository.findById(id);
        if (customers.isPresent()) {
            Float check1 = customer.getAmount();
            Float check2 = customers.get().getBalance();
            Float checks = check1 + check2;
            customers.get().setBalance(checks);
            return customerResipository.save(customers.get());
        }
        return null;
    }

    // Get all Customers
    public List<CreateCustomerResponse> getAllCustomers() {
        List<Customer> customers =customerResipository.findAll();
       return customers.stream().map(customer -> mapTogetAllCustomersCreateCustomerResponse(customer)).toList();
    }

    private CreateCustomerResponse mapTogetAllCustomersCreateCustomerResponse(Customer customer) {
        return CreateCustomerResponse.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .secondName(customer.getSecondName())
                .username(customer.getUsername())
                .accountNumber(customer.getAccountNumber())
                .email(customer.getEmail())
                .build();
    }



    /* Get user by id User */
public Optional<Customer> getCustomerById (Long id){
        return customerResipository.findById(id);
}
    /* Update User */
    public Customer updateCustomer(Long id, Customer customer) {
        Optional<Customer> customers = customerResipository.findById(id);
        if (customers.isPresent()) {
            Customer existingCustomer = customers.get();
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setSecondName(customer.getSecondName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setUsername(customer.getUsername());
            existingCustomer.setPassword(customer.getPassword());
            return customerResipository.save(existingCustomer);
        }

        return null;
    }



    /* withdrawal */
    public Customer withrawal(Long id, Customer customer){
        Optional<Customer> customers = customerResipository.findById(id);
        if (customers.isPresent()) {
            Float comot1 = customer.getAmount();
            Float comot2 = customers.get().getBalance();
            Float comot = comot2 - comot1;
            System.out.println(comot);
            customers.get().setBalance(comot);
            return customerResipository.save(customers.get());
        }
        return null;
    }

    /*get details to transfer money */
    public Customer transferdetails(Long id, Customer customer){
Optional<Customer> customers = customerResipository.findById(id);
if (customers.isPresent()){
    Float money1 = customer.getAmount();
    String  accountnumber = customer.getAccountNumber();
    System.out.println(accountnumber);
    Optional<Customer> customer2 = Optional.ofNullable(customerResipository.findByAccountNumber(accountnumber));
    if (customer2.isPresent()){
        Float mybalance = customer2.get().getBalance();
        Float add = money1 + mybalance;
        customer2.get().setBalance(add);
        Float balancee = customers.get().getBalance();
        Float amountt = balancee - money1;
        customers.get().setBalance(amountt);
        return customerResipository.save(customer2.get());
    }
    return customerResipository.save(customers.get());
}
        return null;
    }

    /*get user by accountnumber*/
    public Optional<Customer> getuserbyaccountnumber(String accountNumber){
        return Optional.ofNullable(customerResipository.findByAccountNumber(accountNumber));

    }

/*Get user balance*/
    public Customer getbalance (Customer balance){
        return customerResipository.save(balance);
    }



    /*generate accountnumber*/
    public Customer generateaccountnumber(Customer customer){
        int min = 9;
        int max = 11;
        BigDecimal createaccountnumber = BigDecimal.valueOf(Math.floor(Math.random() * (max - min + 1) + min));
        String numbers = createaccountnumber.toString();
        customer.setAccountNumber(numbers);
        return customer;
    }

    }
