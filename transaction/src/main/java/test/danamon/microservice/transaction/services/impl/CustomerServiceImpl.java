package test.danamon.microservice.transaction.services.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import test.danamon.microservice.transaction.dto.CustomerBankDto;
import test.danamon.microservice.transaction.dto.MessageDto;
import test.danamon.microservice.transaction.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final String HTTP_STRING = "http://";
    private static final String URL_GET_CUSTOMERBYNOREK = "/users/api/v1/customers/norek/";
    private static final String URL_GET_PATCHCUSTOMER = "/users/api/v1/customers";

    @Value("${rabbitmq.exchange.balanceuser}")
    private String exchange;

    @Value("${rabbitmq.routingkey.balanceuser}")
    private String routingkey;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${service.customername}")
    private String customerService;

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "getCustomerBankByNorek", fallbackMethod = "getCustomerBankDefault")
    @Override
    public CustomerBankDto getCustomerBankByNorek(String norekening) {
        ResponseEntity<CustomerBankDto> responseEntity = restTemplate.getForEntity(HTTP_STRING+ customerService + URL_GET_CUSTOMERBYNOREK + norekening,
            CustomerBankDto.class);
        return responseEntity.getBody();
    }
 
    public CustomerBankDto getCustomerBankDefault(Exception e){
        return null;
    }

    @CircuitBreaker(name = "sendBalanceByNorek", fallbackMethod = "sendBalanceByNorekDefault")
    @Override
    public MessageDto sendBalanceByNorek(CustomerBankDto customerbank) {
        MessageDto loginResponse = new MessageDto() ;
        String urlString = HTTP_STRING + customerService + URL_GET_PATCHCUSTOMER;
        try {
            loginResponse = restTemplate.patchForObject(urlString, customerbank, MessageDto.class);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return loginResponse;
    }

    public MessageDto sendBalanceByNorekDefault(Exception e){
        return null;
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public void publishMessage(CustomerBankDto customerBankDto) {
        amqpTemplate.convertAndSend(exchange, routingkey, customerBankDto);
    }   
}
