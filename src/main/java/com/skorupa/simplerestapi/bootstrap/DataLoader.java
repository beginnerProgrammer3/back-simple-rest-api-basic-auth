package com.skorupa.simplerestapi.bootstrap;

import com.skorupa.simplerestapi.model.ApkUser;
import com.skorupa.simplerestapi.model.Car;
import com.skorupa.simplerestapi.model.Customer;
import com.skorupa.simplerestapi.repository.CarRepository;
import com.skorupa.simplerestapi.repository.CustomerRepository;
import com.skorupa.simplerestapi.repository.UserRepository;
import com.skorupa.simplerestapi.repository.VerificationTokenRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.skorupa.simplerestapi.security.PasswordConfig.passwordEncoder;

@Component
public class DataLoader implements CommandLineRunner {

    CarRepository carRepository;
    UserRepository userRepository;
    VerificationTokenRepository verificaationTokenRepository;
    CustomerRepository customerRepository;

    public DataLoader(CarRepository carRepository,
                      UserRepository userRepository,
                      VerificationTokenRepository verificaationTokenRepository,
                      CustomerRepository customerRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.verificaationTokenRepository = verificaationTokenRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Car car1 = new Car("SUBARU","Impreza","EZD",2000.00,2423423L,16000.00,"https://ireland.apollo.olxcdn.com/v1/files/eyJmbiI6InlrODZ3aTRuenM2cDItT1RPTU9UT1BMIiwidyI6W3siZm4iOiJ3ZzRnbnFwNnkxZi1PVE9NT1RPUEwiLCJzIjoiMTYiLCJwIjoiMTAsLTEwIiwiYSI6IjAifV19.H1HEScr1hIH4w2YZZ3FWwVNPd_DIyukplrOw1MimAlA/image;s=1080x720");
        Car car2 = new Car("AUDI","A3","AGN",1800.00,223234L,6000.00,"https://thumbs.img-sprzedajemy.pl/1000x901c/48/81/18/piekne-audi-a3-8l-18t-audi-dukla-519648130.jpg");
        ApkUser apkUser = new ApkUser("user","www@wp",passwordEncoder().encode("1234"),"USER",false);
        Customer custRandom = new Customer("Jacek", "Skorupa", "ul.Przyjazni 22/44", "Wroclaw",
                "33-333","332223432","qwqe334d");
        apkUser.setCustomer(custRandom);

//        apkUser.setToken(token1);
//        verificaationTokenRepository.save(token1);
        userRepository.save(apkUser);
        customerRepository.save(custRandom);


        ApkUser apkUser1 = new ApkUser("admin","www@wp",passwordEncoder().encode("1234"),"USER",true);

//        apkUser1.setToken(token2);
//        verificaationTokenRepository.save(token2);
        userRepository.save(apkUser1);


        carRepository.save(car1);
        carRepository.save(car2);

    }
}
