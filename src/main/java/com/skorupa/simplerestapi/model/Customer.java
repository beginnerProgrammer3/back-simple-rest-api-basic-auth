package com.skorupa.simplerestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "customer")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "firstName",
        "lastName",
        "addressLine1",
        "addressLine2",
        "postcode",
        "phoneNumber",
        "driverLicenseNumber"
})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("addressLine1")
    private String addressLine1;
    @JsonProperty("addressLine2")
    private String addressLine2;

    @JsonProperty("postcode")
    private String postcode;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("driverLicenseNumber")
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
    this.bookingSet = new HashSet<>();
    }

}
