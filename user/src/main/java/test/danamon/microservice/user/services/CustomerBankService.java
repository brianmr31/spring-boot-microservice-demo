package test.danamon.microservice.user.services;

import test.danamon.microservice.user.config.BadRequestException;
import test.danamon.microservice.user.dto.CustomerBankDto;
import test.danamon.microservice.user.dto.MessageDto;
import test.danamon.microservice.user.entities.CustomerBankEntity;

public interface CustomerBankService {
    
    public CustomerBankEntity getById(String id) throws BadRequestException ;
    public CustomerBankEntity getByNorek(String norek) throws BadRequestException ;
    public MessageDto patchCustomerBank(CustomerBankDto data) throws BadRequestException ;
}
