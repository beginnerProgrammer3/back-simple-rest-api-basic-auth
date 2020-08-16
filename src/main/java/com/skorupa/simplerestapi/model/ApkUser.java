package com.skorupa.simplerestapi.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;


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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
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
