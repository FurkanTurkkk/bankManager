package com.bankManager.bankManager.DTO.Converter;

import com.bankManager.bankManager.DTO.AccountCustomerDTO;
import com.bankManager.bankManager.DTO.CustomerDTO;
import com.bankManager.bankManager.Model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDTOConverter {

    private final AccountDTOConverter accountDTOConverter;

    public CustomerDTOConverter(AccountDTOConverter accountDTOConverter) {
        this.accountDTOConverter = accountDTOConverter;
    }

    public AccountCustomerDTO convertToAccountCustomerDto(Customer customer){


        if(customer==null){
            AccountCustomerDTO accountCustomerDTO=new AccountCustomerDTO();
            accountCustomerDTO.setName(" ");
            accountCustomerDTO.setSurName(" ");
            return accountCustomerDTO;
        }
        else {
            AccountCustomerDTO accountCustomerDTO=new AccountCustomerDTO(customer.getName(),
                    customer.getSurName(),
                    customer.getPhoneNumber(),
                    customer.getEmailAddress(),
                    customer.getBirthDay());
            return accountCustomerDTO;
        }
    }

    public CustomerDTO convertToCustomerDto(Customer customer){

        return new CustomerDTO(customer.getName(),customer.getSurName(),
                customer.getPhoneNumber(),customer.getEmailAddress(),
                customer.getBirthDay(),customer.getAccounts().stream()
                .map(account -> accountDTOConverter.convertToAccountDto(account))
                .collect(Collectors.toSet()));

    }

}
