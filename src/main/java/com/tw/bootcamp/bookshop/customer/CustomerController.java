package com.tw.bootcamp.bookshop.customer;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {
    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    @Operation(summary = "List all Customers")
    List<CustomerResponse> list(){
        List<Customer> customers = customerService.fetchAll();
        return customers.stream()
                .map(customer -> customer.toResponse())
                .collect(Collectors.toList());
    }

    @PostMapping("/customers")
    ResponseEntity<CustomerResponse> addCustomer(@RequestBody CreateCustomerRequest customerRequest){
        Customer customer = customerService.create(customerRequest);
        return new ResponseEntity<>(customer.toResponse(), HttpStatus.CREATED);
    }
}
