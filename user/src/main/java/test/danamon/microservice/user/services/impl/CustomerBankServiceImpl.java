package test.danamon.microservice.user.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.danamon.microservice.user.config.BadRequestException;
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
    public CustomerBankEntity getById(String id) throws BadRequestException {
        CustomerBankEntity tmp = this.customerBankRepository.getById(id);
        if( tmp == null ){
            throw new BadRequestException("Error id not found");
        }
        return tmp;
    }

    @Override
    public CustomerBankEntity getByNorek(String norek) throws BadRequestException {
        CustomerBankEntity tmp = this.customerBankRepository.getByNorek(norek);
        if( tmp == null ){
            throw new BadRequestException("Error id not found");
        }
        return tmp;
    }

    @Override
    public MessageDto patchCustomerBank(CustomerBankDto data) throws BadRequestException {
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
