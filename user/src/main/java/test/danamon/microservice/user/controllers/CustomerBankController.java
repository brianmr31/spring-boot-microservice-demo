package test.danamon.microservice.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import test.danamon.microservice.user.dto.CustomerBankDto;
import test.danamon.microservice.user.dto.MessageDto;
import test.danamon.microservice.user.entities.CustomerBankEntity;
import test.danamon.microservice.user.services.CustomerBankService;

@RestController
public class CustomerBankController {
    
    @Autowired
    private CustomerBankService customerBankService;

    @GetMapping("/api/v1/customers/{id}")
    public CustomerBankEntity getById(@PathVariable String id ){
        return this.customerBankService.getById(id);
    }

    @GetMapping("/api/v1/customers/norek/{rek}")
    public CustomerBankEntity getByRekening(@PathVariable String rek ){
        return this.customerBankService.getByNorek(rek);
    }

    @PatchMapping("/api/v1/customers")
    public MessageDto patchCustomerBank(@Valid @RequestBody CustomerBankDto data){
        return this.customerBankService.patchCustomerBank(data);
    }
}
