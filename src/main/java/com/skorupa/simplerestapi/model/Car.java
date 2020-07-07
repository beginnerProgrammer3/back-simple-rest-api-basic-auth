package com.skorupa.simplerestapi.model;

import ch.qos.logback.core.rolling.helper.TimeBasedArchiveRemover;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Car {


    @Id
    @GeneratedValue
    private Long id;

    private String mark;
    private String name;
    private String engine;
    private Double capacityEngine;
    private Long kilometers;
    private Double price;

    public Car() {
    }

    public Car(String mark, String name, String engine,
               Double capacityEngine, Long kilometers, Double price) {
        this.mark= mark;
        this.name = name;
        this.engine = engine;
        this.capacityEngine = capacityEngine;
        this.kilometers = kilometers;
        this.price = price;
    }
}


