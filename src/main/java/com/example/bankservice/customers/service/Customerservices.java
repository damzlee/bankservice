package com.example.bankservice.customers.service;
import com.example.bankservice.customers.model.Customer;
import com.example.bankservice.customers.repository.CustomerResipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class Customerservices {

    @Autowired
    private CustomerResipository customerResipository;

    /* Create User */
    public Customer Create(Customer customer){
        return customerResipository.save(customer);
    }
    // Get all users
    public List<Customer> getAllUsers() {
        return customerResipository.findAll();
    }

    /* Get user by id User */
    public Optional<Customer> getAUserbyid(Long id){
        return customerResipository.findById(id);
}

public Optional<Customer> getCustomerById (Long id){return customerResipository.findById(id);}

/*get user by accountnumber*/
    public Optional<Customer> getuserbyaccountnumber(String accountNumber){
        return Optional.ofNullable(customerResipository.findByAccountNumber(accountNumber));

    }

/*Get user balance*/
    public Customer getbalance (Customer balance){
        return customerResipository.save(balance);
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
    /*generate accountnumber*/
    public Customer generateaccountnumber(Customer customer){
        int min = 9;
        int max = 11;
        BigDecimal createaccountnumber = BigDecimal.valueOf(Math.floor(Math.random() * (max - min + 1) + min));
        String numbers = createaccountnumber.toString();
        customer.setAccountNumber(numbers);
        return customerResipository.save(customer);
    }

    /* check balanceafteradd*/
    public Customer balanceafteradd (Customer customer){
        Float check1 = balanceafteradd(customer).getAmount();
        Float check2 = getbalance(customer).getBalance();
        Float checks = check1+check2;
        customer.setBalance(checks);
        return customerResipository.save(customer);
    }

/* check balanceafterwithdrawal */
    public Customer balanceafterwithrawal(Customer customer){
        Float comot1 = balanceafterwithrawal(customer).getAmount();
        Float comot2 = getbalance(customer).getBalance();
        Float comot = comot2-comot1;
        customer.setBalance(comot);
        return customerResipository.save(customer);
    }

    /*get details to transfer money */
    public Customer transferdetails(Customer customer, String accountnumber){

        Optional<Customer> accountno = Optional.ofNullable(customerResipository.findByAccountNumber(accountnumber));
        if (accountno.isPresent()) {
            Customer existingCustomer = accountno.get();
            existingCustomer.setAccountNumber(customer.getAccountNumber());
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setSecondName(customer.getSecondName());
            existingCustomer.setUsername(customer.getUsername());
            return customerResipository.save(existingCustomer);
        }
        return null;
    }

    }
