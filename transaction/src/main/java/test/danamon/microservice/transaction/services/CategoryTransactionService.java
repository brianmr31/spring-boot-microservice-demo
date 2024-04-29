package test.danamon.microservice.transaction.services;

import java.util.List;

import test.danamon.microservice.transaction.entities.CategoryTransactionEntity;

public interface CategoryTransactionService {
    
    public List<CategoryTransactionEntity> findAll();
}
