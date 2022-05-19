package com.sunglowsys.controller;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerResource {

        @Autowired
        private CustomerService customerService;


        @PostMapping("/customers")
        public Customer create(@RequestBody Customer customer) {
            return customerService.save(customer);
        }


        @PutMapping("/customers/{id}")
        public Customer update(@RequestBody Customer customer, @PathVariable("id") Long id){
            return customerService.update(customer,id);
        }


        @GetMapping("/customers")
        public List<Customer> getAll() {
            List<Customer> customers=customerService.findAll();
            return customers;
        }


        @GetMapping("/customers/{id}")
        public Customer getById(@PathVariable("id") Long id) {
            return customerService.findById(id);
        }


        @DeleteMapping("/customers/{id}")
        public void delete(@PathVariable("id") Long id) {
            customerService.delete(id);
        }

    }

