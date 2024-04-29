package test.danamon.microservice.transaction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import test.danamon.microservice.transaction.dto.MessageDto;
import test.danamon.microservice.transaction.dto.TransactionDto;
import test.danamon.microservice.transaction.services.TransactionService;

@RestController
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/api/v1/transactions")
    public MessageDto transcation(@Valid @RequestBody TransactionDto data ) throws Exception{
        return this.transactionService.transaction(data);
    }
}
