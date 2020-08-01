package com.skorupa.simplerestapi.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
public class ApkUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String status;
    @Column(unique = true)
    private String username;
    private String email;
    private String password;
    private String role;
    private boolean isEnabled;

    @OneToOne
    private VerificationToken token;

    public ApkUser(String apkUser_successfully_authenticated) {
    }

    public ApkUser(){

    }

    public ApkUser(String status, String username,
                   String email, String password, String role, boolean isEnabled) {
        this.status = status;
        this.username=username;
        this.password=password;
        this.role=role;
        this.email=email;
        this.isEnabled=isEnabled;
    }

}
