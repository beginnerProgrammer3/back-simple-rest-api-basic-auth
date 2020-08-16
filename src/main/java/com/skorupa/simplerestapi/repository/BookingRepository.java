package com.skorupa.simplerestapi.repository;

import com.skorupa.simplerestapi.model.Booking;
import org.springframework.data.repository.CrudRepository;


public interface BookingRepository extends CrudRepository<Booking, Long> {

}
