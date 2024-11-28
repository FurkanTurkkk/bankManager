package com.bankManager.bankManager.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TransactionType transactionType;

    @Column(nullable = false)
    private Long amount;

    private LocalDate transactionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id",nullable = false,unique = true)
    private Account account;

    public Transaction() {
    }

    public Transaction(TransactionType transactionType, Long amount, LocalDate transactionDate, Account account) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.account = account;
    }
}

