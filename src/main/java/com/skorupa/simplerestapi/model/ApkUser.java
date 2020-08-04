package com.skorupa.simplerestapi.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
public class ApkUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String email;
    private String password;
    private String role;
    private boolean isEnabled;

//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "apkUser")
//    private VerificationToken token;

    @OneToOne
    private Customer customer;



    public ApkUser(String apkUser_successfully_authenticated) {
    }

    public ApkUser(){
        this.isEnabled=false;
    }

    public ApkUser(String username,
                   String email, String password, String role, boolean isEnabled) {

        this.username=username;
        this.password= password;
        this.role=role;
        this.email=email;
        this.isEnabled=isEnabled;

    }

}
