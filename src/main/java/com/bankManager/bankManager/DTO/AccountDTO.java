package com.bankManager.bankManager.DTO;

import com.bankManager.bankManager.Model.Transaction;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class AccountDTO {

    private LocalDate creationDate;
    private String accountNumber;
    private Long balance;
    private Set<TransactionDTO> transactions;
    private CustomerDTO customerDTO;

    public AccountDTO() {
    }

    public AccountDTO(LocalDate creationDate,
                      String accountNumber, Long balance,
                      Set<TransactionDTO> transactions,
                      CustomerDTO customerDTO) {

        this.creationDate = creationDate;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = transactions;
        this.customerDTO = customerDTO;
    }
}
