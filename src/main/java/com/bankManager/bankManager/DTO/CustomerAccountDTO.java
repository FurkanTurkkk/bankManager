package com.bankManager.bankManager.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerAccountDTO {

    private LocalDate creationDate;
    private String accountNumber;
    private Long balance;

    public CustomerAccountDTO() {
    }

    public CustomerAccountDTO(LocalDate creationDate, String accountNumber, Long balance) {
        this.creationDate = creationDate;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}
