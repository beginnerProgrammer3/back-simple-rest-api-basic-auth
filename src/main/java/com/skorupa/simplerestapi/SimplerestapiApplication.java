package com.skorupa.simplerestapi;

import com.skorupa.simplerestapi.model.Car;
import com.skorupa.simplerestapi.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@EnableSwagger2
@SpringBootApplication
public class SimplerestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimplerestapiApplication.class, args);
    }

}
