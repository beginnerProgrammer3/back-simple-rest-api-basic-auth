package com.skorupa.simplerestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long id;
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String postcode;
    private String phoneNumber;
    private String driverLicenseNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Booking> bookingSet;

    public Customer(String firstName,String lastName,
                    String addressLine1, String addressLine2,
                    String postcode, String phoneNumber,
                    String driverLicenseNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.addressLine1 = addressLine1;
    this.addressLine2 = addressLine2;
    this.postcode = postcode;
    this.phoneNumber = phoneNumber;
    this.driverLicenseNumber = driverLicenseNumber;
    }

}
