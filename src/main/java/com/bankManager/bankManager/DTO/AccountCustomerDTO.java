package com.bankManager.bankManager.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AccountCustomerDTO {
    private String name;
    private String surName;
    private String phoneNumber;
    private String emailAddress;
    private LocalDate birthDay;

    public AccountCustomerDTO() {
    }

    public AccountCustomerDTO(String name, String surName, String phoneNumber, String emailAddress, LocalDate birthDay) {
        this.name = name;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.birthDay = birthDay;
    }
}
