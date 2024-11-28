package com.bankManager.bankManager.DTO;

import com.bankManager.bankManager.Model.Account;
import com.bankManager.bankManager.Model.TransactionType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionDTO {

    private TransactionType transactionType;
    private Long amount;
    private LocalDate transactionDate;
    private Account account;

    public TransactionDTO() {
    }

    public TransactionDTO(TransactionType transactionType,
                          Long amount,
                          LocalDate transactionDate,
                          Account account) {

        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.account=account;
    }
}
