package com.bankManager.bankManager.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class CustomerAccountDTO {

    private LocalDate creationDate;
    private String accountNumber;
    private Long balance;
    private CustomerDTO customer;

    public CustomerAccountDTO() {
    }

    public CustomerAccountDTO(LocalDate creationDate, String accountNumber, Long balance, CustomerDTO customer) {
        this.creationDate = creationDate;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

}
