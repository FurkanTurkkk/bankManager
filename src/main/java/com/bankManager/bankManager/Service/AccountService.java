package com.bankManager.bankManager.Service;

import com.bankManager.bankManager.DTO.AccountDTO;
import com.bankManager.bankManager.DTO.Converter.AccountDTOConverter;
import com.bankManager.bankManager.DTO.Request.RequestBodyForCreateAccount;
import com.bankManager.bankManager.Model.Account;
import com.bankManager.bankManager.Model.Customer;
import com.bankManager.bankManager.Model.Transaction;
import com.bankManager.bankManager.Repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDTOConverter converter;

    public AccountService(AccountRepository accountRepository, CustomerService customerService, AccountDTOConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = converter;
    }

    public AccountDTO addAccount(RequestBodyForCreateAccount request){
        Customer customer=customerService.findCustomerById(request.getCustomerId());

        Account account=new Account(LocalDate.now(),request.getInitialCredit(),customer);

        if(request.getInitialCredit()>0){
            Transaction transaction=new Transaction();
            transaction.setAccount(account);
            transaction.setTransactionDate(LocalDate.now());
            transaction.setAmount(request.getInitialCredit());
            account.getTransactions().add(transaction);
        }

        accountRepository.save(account);
        return converter.convertToAccountDto(account);

    }
}
