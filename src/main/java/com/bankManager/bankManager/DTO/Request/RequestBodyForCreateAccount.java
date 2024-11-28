package com.bankManager.bankManager.DTO.Request;

import lombok.Data;

@Data
public class RequestBodyForCreateAccount {

    private Long customerId;
    private Long initialCredit=0L;

}
