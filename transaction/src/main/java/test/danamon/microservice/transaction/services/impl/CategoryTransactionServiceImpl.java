package test.danamon.microservice.transaction.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.danamon.microservice.transaction.entities.CategoryTransactionEntity;
import test.danamon.microservice.transaction.repositories.CategoryTransactionRepository;
import test.danamon.microservice.transaction.services.CategoryTransactionService;

@Service
public class CategoryTransactionServiceImpl implements CategoryTransactionService {

    @Autowired
    private CategoryTransactionRepository categoryTransactionRepository;

    @Override
    public List<CategoryTransactionEntity> findAll() {
        return this.categoryTransactionRepository.findAll();
    }
    
}
