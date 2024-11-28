package com.bankManager.bankManager.DTO.Converter;

import com.bankManager.bankManager.DTO.TransactionDTO;
import com.bankManager.bankManager.Model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDTOConverter {

    public TransactionDTO convertToTransactionDto(Transaction transaction){

        return new TransactionDTO(transaction.getTransactionType(),
                transaction.getAmount(),transaction.getTransactionDate(),
                transaction.getAccount());
    }
}
