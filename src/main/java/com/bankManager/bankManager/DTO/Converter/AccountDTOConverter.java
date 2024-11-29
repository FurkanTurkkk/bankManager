package com.bankManager.bankManager.DTO.Converter;


import com.bankManager.bankManager.DTO.AccountDTO;
import com.bankManager.bankManager.DTO.CustomerAccountDTO;
import com.bankManager.bankManager.Model.Account;
import com.bankManager.bankManager.Model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AccountDTOConverter {
        private final CustomerDTOConverter converter;

    public AccountDTOConverter(CustomerDTOConverter converter) {
        this.converter = converter;
    }

    public AccountDTO convertToAccountDto(Account account){
        return new AccountDTO(account.getCreationDate(),
                account.getAccountNumber(),
                account.getBalance(),
                converter.convertToCustomerDto(account.getCustomer()));
    }

    public CustomerAccountDTO convertToCustumerAccountDto(Account account){
        return new CustomerAccountDTO(account.getCreationDate(),
                account.getAccountNumber(),
                account.getBalance(),
                converter.convertToCustomerDto(account.getCustomer()));
    }

}
