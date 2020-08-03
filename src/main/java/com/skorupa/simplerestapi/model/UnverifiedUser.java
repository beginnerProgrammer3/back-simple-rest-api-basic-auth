package com.skorupa.simplerestapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UnverifiedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private Boolean isActive;

    @OneToOne(mappedBy= "unverifiedUser", cascade = CascadeType.ALL)
    private VerificationToken verificationToken;

    @OneToOne(mappedBy = "unverifiedUser_id", cascade = CascadeType.ALL)
    private ApkUser apkUser;
}
