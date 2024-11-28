package com.bankManager.bankManager.DTO.Converter;


import com.bankManager.bankManager.DTO.AccountDTO;
import com.bankManager.bankManager.Model.Account;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AccountDTOConverter {

    private final TransactionDTOConverter transactionDTOConverter;
    private final CustomerDTOConverter customerDTOConverter;

    public AccountDTOConverter(TransactionDTOConverter transactionDTOConverter, CustomerDTOConverter customerDTOConverter) {
        this.transactionDTOConverter = transactionDTOConverter;
        this.customerDTOConverter = customerDTOConverter;
    }

    public AccountDTO convertToAccountDto(Account account){

        return new AccountDTO(account.getCreationDate(),
                account.getAccountNumber(),
                account.getBalance(),
                account.getTransactions().stream()
                        .map(transaction -> transactionDTOConverter.convertToTransactionDto(transaction)).collect(Collectors.toSet()),
                customerDTOConverter.convertToCustomerDto(account.getCustomer()));
    }

}
