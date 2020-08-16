package com.skorupa.simplerestapi.controllers;

import com.skorupa.simplerestapi.model.Booking;
import com.skorupa.simplerestapi.model.Customer;
import com.skorupa.simplerestapi.repository.BookingRepository;
import com.skorupa.simplerestapi.repository.CarRepository;
import com.skorupa.simplerestapi.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


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

    @GetMapping({"/{id}"})
    public List<Booking> getAllBookByCustomer(@PathVariable("id") Long id){
        List<Booking> bookingSet = (List<Booking>) bookingRepository.findAll();
        List<Booking> bookingList = bookingSet.stream().filter(booking -> booking.getCustomer()
                .getId().equals(id)).collect(Collectors.toList());

        return bookingList;

        }
    }
