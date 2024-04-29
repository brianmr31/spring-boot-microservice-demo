package test.danamon.microservice.transaction.services;

import test.danamon.microservice.transaction.dto.CustomerBankDto;
import test.danamon.microservice.transaction.dto.MessageDto;

public interface CustomerService {
 
    public CustomerBankDto getCustomerBankByNorek(String norek);
    public MessageDto sendBalanceByNorek(CustomerBankDto customerbank);

    public void publishMessage(CustomerBankDto customerBankDto);
}
