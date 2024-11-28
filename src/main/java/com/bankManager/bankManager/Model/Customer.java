package com.bankManager.bankManager.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surName;
    private String phoneNumber;
    private String emailAddress;
    private LocalDate birthDay;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Account> accounts;

    public Customer() {
    }

    public Customer(String name,
                    String surName,
                    String phoneNumber,
                    String emailAddress,
                    LocalDate birthDay,
                    Set<Account> accounts) {

        this.name = name;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.birthDay = birthDay;
        this.accounts = accounts;
    }
}
