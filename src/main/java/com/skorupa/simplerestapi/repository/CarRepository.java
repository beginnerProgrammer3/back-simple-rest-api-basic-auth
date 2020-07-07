package com.skorupa.simplerestapi.repository;

import com.skorupa.simplerestapi.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {
}
