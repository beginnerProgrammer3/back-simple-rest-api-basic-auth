package com.skorupa.simplerestapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VerificationToken {

    private static final String notVerified = "PENDING";
    private static final String verified = "VERIFIED";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;
    private LocalDate expireDate;
    private LocalDate issuedDateTime;
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private ApkUser apkUser;

    public VerificationToken(ApkUser apkUser) {
        this.apkUser = apkUser;
        this.token = UUID.randomUUID().toString();
        this.issuedDateTime = LocalDate.now();
        this.expireDate = LocalDate.now().plusDays(1);
        this.status = notVerified;
    }

}

