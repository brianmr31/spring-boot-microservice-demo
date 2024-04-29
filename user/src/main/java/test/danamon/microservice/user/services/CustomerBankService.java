package test.danamon.microservice.user.services;

import test.danamon.microservice.user.dto.CustomerBankDto;
import test.danamon.microservice.user.dto.MessageDto;
import test.danamon.microservice.user.entities.CustomerBankEntity;

public interface CustomerBankService {
    
    public CustomerBankEntity getById(String id);
    public CustomerBankEntity getByNorek(String norek);
    public MessageDto patchCustomerBank(CustomerBankDto data);
}
