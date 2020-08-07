package com.skorupa.simplerestapi.repository;

import com.skorupa.simplerestapi.model.Booking;
import com.skorupa.simplerestapi.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Long> {
}
