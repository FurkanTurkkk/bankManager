package com.bankManager.bankManager.DTO.Request;

import lombok.Data;

@Data
public class RequestBodyForCreateCustomer {
    private String name;
    private String surName;
    private String phoneNumber;
    private String emailAddress;

    public RequestBodyForCreateCustomer(String name, String surName, String phoneNumber, String emailAddress) {
        this.name = name;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
}
