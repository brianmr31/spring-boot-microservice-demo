package test.danamon.microservice.transaction.services;

import test.danamon.microservice.transaction.dto.MessageDto;
import test.danamon.microservice.transaction.dto.TransactionDto;

public interface TransactionService {
    
    public MessageDto transaction(TransactionDto data) throws Exception;
}
