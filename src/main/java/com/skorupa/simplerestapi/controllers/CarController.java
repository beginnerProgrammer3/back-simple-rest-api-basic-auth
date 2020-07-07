package com.skorupa.simplerestapi.controllers;

import com.skorupa.simplerestapi.model.Car;
import com.skorupa.simplerestapi.model.User;
import com.skorupa.simplerestapi.repository.CarRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/cars"})
public class CarController {

    CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @GetMapping(produces = "application/json")
    public List<Car> firstPage(){
        return (List<Car>) carRepository.findAll();
    }

    @GetMapping(produces = "application/json")
    @RequestMapping( {"/validateLogin"} )
    public User validateLogin() {
        return new User("User successfully authenticated");
    }


    @DeleteMapping(path = {"/{id}"})
    public Map<String, Boolean> delete(@PathVariable("id") Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found car: " + id));
        carRepository.delete(car);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PostMapping
    public Car create(@RequestBody Car car){
        carRepository.save(car);
        return car;
    }

    @GetMapping(path = {"/{id}"})
    public Car getCarById(@PathVariable("id") Long id){
        return carRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not found car with id: " + id));
    }



}
