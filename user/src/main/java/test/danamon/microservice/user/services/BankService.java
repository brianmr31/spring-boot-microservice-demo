package test.danamon.microservice.user.services;

import java.util.List;

import test.danamon.microservice.user.entities.BankEntity;

public interface BankService {
    public List<BankEntity> findAll();
}
