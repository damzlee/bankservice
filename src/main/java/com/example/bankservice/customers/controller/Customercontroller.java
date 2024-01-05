package com.example.bankservice.customers.controller;

import com.example.bankservice.customers.dto.CreateCustomerRequest;
import com.example.bankservice.customers.dto.CreateCustomerResponse;
import com.example.bankservice.customers.model.Customer;
import com.example.bankservice.customers.service.Customerservices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/customer/")
@RequiredArgsConstructor
public class Customercontroller {

    @Autowired
    private final Customerservices customerservices;

    //Create new user
    @PostMapping("/createCustomer")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createuser(@RequestBody CreateCustomerRequest customerRequest){

        return customerservices.CreateUser(customerRequest);
    }
    @PostMapping("/addmoney")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Customer addmoney(@RequestParam Long id ,@RequestBody Customer customer){
        return customerservices.addmoney(id, customer);
    }

    @GetMapping("/getAllCustomers")
    @ResponseStatus(HttpStatus.OK)
    public List<CreateCustomerResponse> getAllCustomers(){

        return customerservices.getAllCustomers();
    }

    //get user by id
    @GetMapping("/getCustomerbyid")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Customer> getUserbyid (@RequestParam Long id){
        return customerservices.getCustomerById(id);
    }

    //Update User
    @PostMapping("/updateuser")
    public Customer updateuser(@RequestParam Long id, @RequestBody Customer customer){
        return customerservices.updateCustomer(id,customer);
    }

//withrawal
    @PostMapping ("/withrawal")
    public Customer withdrawal(@RequestParam Long id , @RequestBody Customer customer){
        return customerservices.withrawal(id,customer);
    }

    //transferdetails
   @PostMapping("/transfer")
    public Customer transfer(@RequestParam Long id, @RequestBody Customer customer){
        return  customerservices.transferdetails(id,customer);
   }
}
