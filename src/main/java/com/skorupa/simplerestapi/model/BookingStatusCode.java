package com.skorupa.simplerestapi.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BookingStatusCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingStatusCode;
    private String bookingStatusDescription;
}
