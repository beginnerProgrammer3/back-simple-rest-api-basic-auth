package com.skorupa.simplerestapi.bootstrap;

import com.skorupa.simplerestapi.model.Car;
import com.skorupa.simplerestapi.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    CarRepository carRepository;

    public DataLoader(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Car car1 = new Car("SUBARU","Impreza","EZD",2000.00,2423423L,16000.00,"https://ireland.apollo.olxcdn.com/v1/files/eyJmbiI6InlrODZ3aTRuenM2cDItT1RPTU9UT1BMIiwidyI6W3siZm4iOiJ3ZzRnbnFwNnkxZi1PVE9NT1RPUEwiLCJzIjoiMTYiLCJwIjoiMTAsLTEwIiwiYSI6IjAifV19.H1HEScr1hIH4w2YZZ3FWwVNPd_DIyukplrOw1MimAlA/image;s=1080x720");
        Car car2 = new Car("AUDI","A3","AGN",1800.00,223234L,6000.00,"https://thumbs.img-sprzedajemy.pl/1000x901c/48/81/18/piekne-audi-a3-8l-18t-audi-dukla-519648130.jpg");

        carRepository.save(car1);
        carRepository.save(car2);
    }
}
