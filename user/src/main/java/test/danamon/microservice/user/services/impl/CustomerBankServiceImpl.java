package test.danamon.microservice.user.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.danamon.microservice.user.dto.CustomerBankDto;
import test.danamon.microservice.user.dto.MessageDto;
import test.danamon.microservice.user.entities.CustomerBankEntity;
import test.danamon.microservice.user.repositories.CustomerBankRepository;
import test.danamon.microservice.user.services.CustomerBankService;

@Service
public class CustomerBankServiceImpl implements CustomerBankService{

    @Autowired
    private CustomerBankRepository customerBankRepository;

    @Override
    public CustomerBankEntity getById(String id) {
        return this.customerBankRepository.getById(id);
    }

    @Override
    public CustomerBankEntity getByNorek(String norek) {
        return this.customerBankRepository.getByNorek(norek);
    }

    @Override
    public MessageDto patchCustomerBank(CustomerBankDto data) {
        String result = "ok";
        CustomerBankEntity tmp = this.getByNorek( data.getNoRekening() );
        try{
            this.customerBankRepository.save( data.marge(tmp) );
        } catch(Exception e){
            e.printStackTrace();
            result = "err";
        }
        return new MessageDto(result);
    }
    
}
