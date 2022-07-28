package com.tw.bootcamp.bookshop.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> fetchAll() {
        return customerRepository.findAllByOrderByNameAsc();
    }

    public Customer create(CreateCustomerRequest customerRequest){
        Customer customer = new Customer(customerRequest.getName());
        return customerRepository.save(customer);
    }
}
