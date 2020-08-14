package com.skorupa.simplerestapi.controllers;

import com.skorupa.simplerestapi.model.ApkUser;
import com.skorupa.simplerestapi.model.Booking;
import com.skorupa.simplerestapi.model.Car;
import com.skorupa.simplerestapi.model.Customer;
import com.skorupa.simplerestapi.repository.CustomerRepository;
import com.skorupa.simplerestapi.repository.UserRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/customer"})
public class CustomerController {

    UserRepository userRepository;
    CustomerRepository customerRepository;

    public CustomerController(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping(path = {"/{name}"})
    public Customer getCustomerByUsername(@PathVariable("name") String name) {
        Optional<Customer> customerToFind = Optional.of(userRepository.findUserByUsername(name).getCustomer());

        Customer cust = customerToFind.get();
        return cust;
    }

    @PutMapping(path = "/{name}")
    public Customer updateCustomerByUsername(@PathVariable("name") String name, @RequestBody Customer customer){
        Optional<Customer> customerDb = Optional.of(userRepository.findUserByUsername(name).getCustomer());
        if(customerDb.isPresent()){
            Customer customerToUpdate = customerDb.get();
            customerToUpdate.setFirstName(customer.getFirstName());
            customerToUpdate.setLastName(customer.getLastName());
            customerToUpdate.setAddressLine1(customer.getAddressLine1());
            customerToUpdate.setAddressLine2(customer.getAddressLine2());
            customerToUpdate.setPostcode(customer.getPostcode());
            customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
            customerToUpdate.setDriverLicenseNumber(customer.getDriverLicenseNumber());
            customerRepository.save(customerToUpdate);
            return customerToUpdate;}
        return null;
    }


//    @PutMapping(path = "/{id}")
//    public Customer updateCustomerById(@PathVariable("id") Long id, @RequestBody Customer customer){
//        Optional<Customer> customerDb = Optional.of(customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found car with id:" + id)));
//        if(customerDb.isPresent()){
//            Customer customerToUpdate = customerDb.get();
//            customerToUpdate.setId(id);
//            customerToUpdate.setAddressLine1(customer.getAddressLine1());
//            customerToUpdate.setAddressLine2(customer.getAddressLine2());
//            customerToUpdate.setPhoneNumber(customer.getPostcode());
//            customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
//            customerToUpdate.setDriverLicenseNumber(customer.getDriverLicenseNumber());
//            customerRepository.save(customerToUpdate);
//            return customerToUpdate;}
//        return null;
//    }

}
