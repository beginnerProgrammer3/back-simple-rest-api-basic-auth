package com.skorupa.simplerestapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@Setter
@AllArgsConstructor
@Entity
@JsonPropertyOrder({
        "id",
        "mark",
        "name",
        "engine",
        "capacityEngine",
        "kilometers",
        "price",
        "image"
})
public class Car {

    @Id
    @GeneratedValue
    @JsonProperty("id")
    public Long id;
    @JsonProperty("mark")
    public String mark;
    @JsonProperty("name")
    public String name;
    @JsonProperty("engine")
    public String engine;
    @JsonProperty("capacityEngine")
    public Double capacityEngine;
    @JsonProperty("kilometers")
    public Long kilometers;
    @JsonProperty("price")
    public Double price;
    @JsonProperty("image")
    public String image;


    public Car() {
    }

    public Car(String mark, String name, String engine,
               Double capacityEngine, Long kilometers, Double price, String image) {
        this.mark= mark;
        this.name = name;
        this.engine = engine;
        this.capacityEngine = capacityEngine;
        this.kilometers = kilometers;
        this.price = price;
        this.image = image;
    }
}


