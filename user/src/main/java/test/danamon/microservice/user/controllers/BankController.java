package test.danamon.microservice.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import test.danamon.microservice.user.entities.BankEntity;
import test.danamon.microservice.user.services.BankService;


@RestController
public class BankController {
    
    @Autowired
    private BankService bankService;


    @GetMapping("/api/v1/banks")
    @Cacheable("banklist")
    public List<BankEntity> findAll(){
        return this.bankService.findAll();
    }
}
