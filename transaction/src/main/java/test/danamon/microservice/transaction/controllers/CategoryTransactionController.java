package test.danamon.microservice.transaction.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import test.danamon.microservice.transaction.entities.CategoryTransactionEntity;
import test.danamon.microservice.transaction.services.CategoryTransactionService;

@RestController
public class CategoryTransactionController {
    
    @Autowired
    private CategoryTransactionService categoryTransactionService;

    @GetMapping("/api/v1/categories")
    public List<CategoryTransactionEntity> findAll(){
        return this.categoryTransactionService.findAll();
    }
}
