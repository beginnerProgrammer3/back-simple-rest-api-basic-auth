package com.skorupa.simplerestapi.model;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
