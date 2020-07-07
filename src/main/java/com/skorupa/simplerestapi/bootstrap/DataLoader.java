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
        Car car1 = new Car("SUBARU","Impreza","EZD",2000.00,2423423L,16000.00);
        Car car2 = new Car("AUDI","A3","AGN",1800.00,223234L,6000.00);

        carRepository.save(car1);
        carRepository.save(car2);
    }
}
