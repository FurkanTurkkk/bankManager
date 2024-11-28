package com.bankManager.bankManager.Service;

import com.bankManager.bankManager.DTO.AccountDTO;
import com.bankManager.bankManager.DTO.Request.RequestBodyForCreateAccount;
import com.bankManager.bankManager.Repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountDTO addAccount(RequestBodyForCreateAccount request){

        return new AccountDTO();
    }
}
