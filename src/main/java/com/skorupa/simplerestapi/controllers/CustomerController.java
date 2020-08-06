package com.skorupa.simplerestapi.controllers;

import com.skorupa.simplerestapi.model.ApkUser;
import com.skorupa.simplerestapi.model.Car;
import com.skorupa.simplerestapi.model.Customer;
import com.skorupa.simplerestapi.repository.CustomerRepository;
import com.skorupa.simplerestapi.repository.UserRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/customer"})
public class CustomerController {

    UserRepository userRepository;
    CustomerRepository customerRepository;

    public CustomerController(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping(path = {"/{id}"})
    public Customer getCustomerById(@PathVariable("id") Long id) {
        Optional<Customer> customerToFind = Optional.ofNullable(userRepository.findApkUserById(id).getCustomer());
        return customerToFind.get();
    }

    @PutMapping(path = "/{id}")
    public Customer updateCustomerById(@PathVariable("id") Long id, @RequestBody Customer customer){
        Optional<Customer> customerDb = Optional.of(customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found car with id:" + id)));
        if(customerDb.isPresent()){
            Customer customerToUpdate = customerDb.get();
            customerToUpdate.setId(id);
            customerToUpdate.setAddressLine1(customer.getAddressLine1());
            customerToUpdate.setAddressLine2(customer.getAddressLine2());
            customerToUpdate.setPhoneNumber(customer.getPostcode());
            customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
            customerToUpdate.setDriverLicenseNumber(customer.getDriverLicenseNumber());
            customerRepository.save(customerToUpdate);
            return customerToUpdate;}
        return null;
    }
}
