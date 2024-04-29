package test.danamon.microservice.user.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.danamon.microservice.user.entities.BankEntity;
import test.danamon.microservice.user.repositories.BankRepository;
import test.danamon.microservice.user.services.BankService;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public List<BankEntity> findAll() {
        return this.bankRepository.findAll();
    }
    
}
