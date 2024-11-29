package com.bankManager.bankManager.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.val;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
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

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Transaction> transactions;

    public Account() {
        Double number=Math.random()*1_000_000_000;
        String sNumber=number.toString();
        this.accountNumber=sNumber;
    }

    public Account(LocalDate creationDate, Long balance, Customer customer) {
        this.creationDate = creationDate;
        this.balance = balance;
        this.customer = customer;
        Double number=Math.random()*1_000_000_000;
        String sNumber=number.toString();
        this.accountNumber=sNumber;
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
        Double number=Math.random()*1_000_000_000;
        String sNumber=number.toString();
        this.accountNumber=sNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(creationDate, account.creationDate) &&
                Objects.equals(accountNumber, account.accountNumber) &&
                Objects.equals(balance, account.balance) &&
                Objects.equals(customer, account.customer) &&
                Objects.equals(transactions, account.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationDate, accountNumber, balance, customer, transactions);
    }
}
