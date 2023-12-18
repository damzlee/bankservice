package com.example.bankservice.customers.controller;

import com.example.bankservice.customers.model.Customer;
import com.example.bankservice.customers.service.Customerservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/customer/{id}")
public class Customercontroller {

    @Autowired
    private Customerservices customerservices;

    //Create new user
    @PostMapping("/createCustomer")
    public Customer createuser(@RequestBody Customer customer){

        return customerservices.Create(customer);
    }


    //get user by id
    @GetMapping("/getUserbyid")
    public Optional<Customer> getUserbyid (@PathVariable Long id){
        return customerservices.getAUserbyid(id);
    }

    //Update User
    @PutMapping("/updateuser")
    public Customer updateuser(@PathVariable Long id, @RequestBody Customer customer){
        return customerservices.updateCustomer(id,customer);
    }

    //accountnumber
    @PutMapping("/accountnumber")
    public Customer accountnumber(@RequestBody Customer customer){
        return customerservices.generateaccountnumber(customer);
    }

    //check
    @GetMapping(path = "/balanceafteraddingmoney",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Customer> balanceafteradding(@RequestParam(name = "id") Long id){
       return customerservices.getCustomerById(id);
    }

    @GetMapping ("/balanceafterwithrawal")
    public Customer balanceafterwithdrawal(@RequestBody Customer customer){
        return customerservices.balanceafterwithrawal(customer);
    }

    @GetMapping("/tranferdetails")
    public Customer tranferdetails( @RequestBody Customer accountnumber, Customer customer){
        return customerservices.transferdetails(customer, String.valueOf(accountnumber));
    }

}
