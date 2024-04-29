package test.danamon.microservice.transaction.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.danamon.microservice.transaction.dto.CustomerBankDto;
import test.danamon.microservice.transaction.dto.LogDto;
import test.danamon.microservice.transaction.dto.MessageDto;
import test.danamon.microservice.transaction.dto.TransactionDto;
import test.danamon.microservice.transaction.repositories.TransactionRepository;
import test.danamon.microservice.transaction.services.CustomerService;
import test.danamon.microservice.transaction.services.LoggingService;
import test.danamon.microservice.transaction.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Value("${spring.application.name}")
    private String name;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private LoggingService loggingService;

    @Autowired
    private CustomerService customerService;

    public CustomerBankDto[] getCustomerBankSrcAndDst(TransactionDto data) throws Exception {
        CustomerBankDto[] result = new CustomerBankDto[2];
        if( data.getNoRekeningSrc().equals( data.getNoRekeningDst() )){
            throw new Exception("Error Customer Bank Src same with Dst ");
        }
        CustomerBankDto customerBankSrc = this.customerService.getCustomerBankByNorek(data.getNoRekeningSrc() );
        if( customerBankSrc == null ){
            throw new Exception("Error Customer Bank Src Not Found");
        }
        CustomerBankDto customerBankDst = this.customerService.getCustomerBankByNorek(data.getNoRekeningDst() );
        if( customerBankDst == null ){
            throw new Exception("Error Customer Bank Dst Not Found");
        }

        double totalTransferSrc = Double.parseDouble(data.getAmount());
        double currentBalanceSrc = customerBankSrc.getBalance() - totalTransferSrc;
        double currentBalanceDst = customerBankDst.getBalance() + totalTransferSrc;
        if( currentBalanceSrc <= 0  ){
            throw new Exception("Error Customer Bank Src Dont Have Balance ");
        }
        customerBankSrc.setBalance(currentBalanceSrc);
        customerBankDst.setBalance(currentBalanceDst);
        result[0] = customerBankSrc;
        result[1] = customerBankDst;
        return result;
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public MessageDto transaction(TransactionDto data) throws Exception {
        CustomerBankDto[] customerBank = this.getCustomerBankSrcAndDst(data);
        
        MessageDto tmp = this.customerService.sendBalanceByNorek(customerBank[0]);
        if( tmp == null ) {
            throw new Exception("Error Send Balance Norek Src ");
        }
        tmp = this.customerService.sendBalanceByNorek(customerBank[1]);
        if( tmp == null ) {
            throw new Exception("Error Send Balance Norek Dst ");
        }

        this.customerService.publishMessage(customerBank[0]);
        this.customerService.publishMessage(customerBank[1]);

        this.loggingService.publishMessage( new LogDto( name, data.toJson() ) );

        return new MessageDto("OK");
    }
}
