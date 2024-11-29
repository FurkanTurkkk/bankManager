package com.bankManager.bankManager.DTO.Converter;

import com.bankManager.bankManager.DTO.AccountCustomerDTO;
import com.bankManager.bankManager.DTO.CustomerDTO;
import com.bankManager.bankManager.Model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDTOConverter {

    public CustomerDTO convertToCustomerDto(Customer customer){
        return new CustomerDTO(customer.getName(),
                customer.getSurName(),
                customer.getPhoneNumber(),
                customer.getEmailAddress(),
                customer.getBirthDay());
    }

}
