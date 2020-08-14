package com.skorupa.simplerestapi.controllers;

import com.skorupa.simplerestapi.model.Booking;
import com.skorupa.simplerestapi.model.Car;
import com.skorupa.simplerestapi.model.Customer;
import com.skorupa.simplerestapi.repository.BookingRepository;
import com.skorupa.simplerestapi.repository.CarRepository;
import com.skorupa.simplerestapi.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = {"/booking"})
public class BookCarController {

    CustomerRepository customerRepository;
    BookingRepository bookingRepository;
    CarRepository carRepository;


    public BookCarController(CustomerRepository customerRepository,
                             BookingRepository bookingRepository,
                             CarRepository carRepository) {
        this.customerRepository = customerRepository;
        this.bookingRepository = bookingRepository;
        this.carRepository = carRepository;
    }

    @PostMapping
    public Booking bookCar(@RequestBody Booking booking){
        return bookingRepository.save(booking);
    }
}
