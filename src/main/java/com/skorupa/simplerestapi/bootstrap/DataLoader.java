package com.skorupa.simplerestapi.bootstrap;

import com.skorupa.simplerestapi.model.*;
import com.skorupa.simplerestapi.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static com.skorupa.simplerestapi.security.PasswordConfig.passwordEncoder;

@Component
public class DataLoader implements CommandLineRunner {

    CarRepository carRepository;
    UserRepository userRepository;
    VerificationTokenRepository verificaationTokenRepository;
    CustomerRepository customerRepository;
    BookingRepository bookingRepository;

    public DataLoader(CarRepository carRepository,
                      UserRepository userRepository,
                      VerificationTokenRepository verificaationTokenRepository,
                      CustomerRepository customerRepository,BookingRepository bookingRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.verificaationTokenRepository = verificaationTokenRepository;
        this.customerRepository = customerRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Car car1 = new Car("SUBARU","Impreza","EZD",2000.00,2423423L,16000.00,"https://ireland.apollo.olxcdn.com/v1/files/eyJmbiI6InlrODZ3aTRuenM2cDItT1RPTU9UT1BMIiwidyI6W3siZm4iOiJ3ZzRnbnFwNnkxZi1PVE9NT1RPUEwiLCJzIjoiMTYiLCJwIjoiMTAsLTEwIiwiYSI6IjAifV19.H1HEScr1hIH4w2YZZ3FWwVNPd_DIyukplrOw1MimAlA/image;s=1080x720");
        Car car2 = new Car("AUDI","A3","AGN",1800.00,223234L,6000.00,"https://thumbs.img-sprzedajemy.pl/1000x901c/48/81/18/piekne-audi-a3-8l-18t-audi-dukla-519648130.jpg");
        carRepository.save(car1);
        carRepository.save(car2);
        ApkUser apkUser = new ApkUser("user","www@wp",passwordEncoder().encode("1234"),"USER",true);
        Customer custRandom = new Customer("Jacek", "Skorupa", "ul.Przyjazni 22/44", "Wroclaw",
                "33-333","332223432","qwqe334d");
        apkUser.setCustomer(custRandom);
        Booking booking = new Booking(custRandom,LocalDate.of(2020,10,12) ,LocalDate.of(2020,11,20), car1);
        Set<Booking> setBooking = new HashSet<>();
        setBooking.add(booking);
        //        apkUser.setToken(token1);
//        verificaationTokenRepository.save(token1);
        custRandom.setBookingSet(setBooking);
        userRepository.save(apkUser);
        customerRepository.save(custRandom);
        bookingRepository.save(booking);



        ApkUser apkUser1 = new ApkUser("admin","www@wp",passwordEncoder().encode("1234"),"USER",true);

        userRepository.save(apkUser1);




    }
}
