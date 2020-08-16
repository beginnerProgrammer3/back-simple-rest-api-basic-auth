package com.skorupa.simplerestapi.controllers;

import com.skorupa.simplerestapi.model.Booking;
import com.skorupa.simplerestapi.model.Car;
import com.skorupa.simplerestapi.model.Customer;
import com.skorupa.simplerestapi.repository.BookingRepository;
import com.skorupa.simplerestapi.repository.CarRepository;
import com.skorupa.simplerestapi.repository.CustomerRepository;
import net.minidev.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
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

    @PostMapping({"/book"})
    public Booking bookCar(@RequestBody Booking booking){
        Customer customer = customerRepository.findCustomerById(booking.getCustomer().getId());
        customer.getBookingSet().add(booking);
        customerRepository.save(customer);
        bookingRepository.save(booking);
        //simple booking soon add date checking and disabling car in main menu
        return booking;
    }
}
