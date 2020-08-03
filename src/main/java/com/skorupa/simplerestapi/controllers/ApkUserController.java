package com.skorupa.simplerestapi.controllers;

import com.skorupa.simplerestapi.model.ApkUser;
import com.skorupa.simplerestapi.model.Car;
import com.skorupa.simplerestapi.model.UnverifiedUser;
import com.skorupa.simplerestapi.model.VerificationToken;
import com.skorupa.simplerestapi.repository.UserRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.skorupa.simplerestapi.security.PasswordConfig.passwordEncoder;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/createuser"})
public class ApkUserController {


    private ApplicationEventPublisher applicationEventPublisher;
    private UserRepository userRepository;

    public ApkUserController(ApplicationEventPublisher applicationEventPublisher, UserRepository userRepository) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.userRepository = userRepository;
    }

    @PostMapping
    public String create(@RequestBody ApkUser apkUser) {

        ApkUser userToFind = userRepository.findUserByEmail(apkUser.getUsername());
        ApkUser userNameToFind = userRepository.findUserByUsername(apkUser.getUsername());
        if (userNameToFind == null && userToFind == null) {


            VerificationToken token = new VerificationToken();
//        apkUser.setToken(token);
            apkUser.setPassword(passwordEncoder().encode(apkUser.getPassword()));
            userRepository.save(apkUser);
            return "User was created successfully";
        } else {
            return "User in db";
        }
    }
}