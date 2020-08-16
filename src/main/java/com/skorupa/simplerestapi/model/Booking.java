package com.skorupa.simplerestapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "booking")
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
public class Booking {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long bookingId;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonProperty("Customer")
    private Customer customer;
    @JsonProperty("pickupDate")
    private LocalDate pickupDate;

    @JsonProperty("dropDate")
    private LocalDate dropDate;

//    private LocalDate pickupDate;
//    private LocalDate dropDate;

//    @ManyToOne
//    @JoinColumn(name = "bookingCodeStatus")
//    private BookingStatusCode bookingStatusCode;

    @ManyToOne
    @JoinColumn(name = "car_id")
    @JsonProperty("Car")
    private Car car;

    public Booking(LocalDate pickupDate,LocalDate dropDate,  Car car, Customer customer) {
        this.customer= customer;
        this.pickupDate = pickupDate;
        this.dropDate = dropDate;
        this.car = car;
    }
}
