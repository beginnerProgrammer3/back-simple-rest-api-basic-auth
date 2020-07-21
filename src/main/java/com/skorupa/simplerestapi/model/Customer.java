package com.skorupa.simplerestapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerID;
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String postcode;
    private String mailAddress;
    private String phoneNumber;
    private String driverLicenseNumber;

    @OneToMany(mappedBy = "customer")
    private Set<Booking> bookingSet;

}
