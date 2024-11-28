package com.bankManager.bankManager.Controller;

import com.bankManager.bankManager.DTO.AccountDTO;
import com.bankManager.bankManager.DTO.Request.RequestBodyForCreateAccount;
import com.bankManager.bankManager.Service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDTO> addAccount(@RequestBody RequestBodyForCreateAccount request){
        return ResponseEntity.ok(accountService.addAccount(request));
    }
}
