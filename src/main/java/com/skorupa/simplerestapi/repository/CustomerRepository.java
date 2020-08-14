package com.skorupa.simplerestapi.repository;

import com.skorupa.simplerestapi.model.ApkUser;
import com.skorupa.simplerestapi.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findCustomerById(Long id);
}
