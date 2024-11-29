package com.bankManager.bankManager.DTO;

import com.bankManager.bankManager.Model.Customer;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class AccountDTO {
    private LocalDate creationDate;
    private String accountNumber;
    private Long balance;
    private CustomerDTO customer;

    public AccountDTO() {
    }

    public AccountDTO(LocalDate creationDate, String accountNumber, Long balance, CustomerDTO customer) {
        this.creationDate = creationDate;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }
}
