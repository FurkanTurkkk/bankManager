package com.bankManager.bankManager.DTO;

import com.bankManager.bankManager.Model.Account;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class CustomerDTO {

    private String name;
    private String surName;
    private String phoneNumber;
    private String emailAddress;
    private LocalDate birthDay;
    private Set<AccountDTO> accounts;

    public CustomerDTO() {
    }

    public CustomerDTO(String name, String surName, String phoneNumber, String emailAddress, LocalDate birthDay) {
        this.name = name;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.birthDay = birthDay;
    }

    public CustomerDTO(String name, String surName, String phoneNumber, String emailAddress, LocalDate birthDay, Set<AccountDTO> accounts) {
        this.name = name;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.birthDay = birthDay;
        this.accounts = accounts;
    }
}
