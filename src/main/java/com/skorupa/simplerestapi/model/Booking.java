package com.skorupa.simplerestapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long bookingId;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private LocalDate pickupDate;
    private LocalDate dropDate;

    @ManyToOne
    @JoinColumn(name = "bookingCodeStatus")
    private BookingStatusCode bookingStatusCode;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public Booking(Customer customer, LocalDate pickupDate,LocalDate dropDate, Car car) {
        this.customer= customer;
        this.pickupDate = pickupDate;
        this.dropDate = dropDate;
        this.car = car;
    }
}
