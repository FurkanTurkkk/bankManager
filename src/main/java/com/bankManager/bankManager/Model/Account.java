package com.bankManager.bankManager.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate creationDate;
    private String accountNumber;
    private Long balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Transaction> transactions;

    public Account() {
    }

    public Account(LocalDate creationDate,
                   String accountNumber,
                   Long balance, Customer customer,
                   Set<Transaction> transactions) {
        this.creationDate = creationDate;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
        this.transactions = transactions;
    }
}
