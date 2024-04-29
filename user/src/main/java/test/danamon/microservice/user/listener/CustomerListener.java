package test.danamon.microservice.user.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.transaction.annotation.Transactional;
import test.danamon.microservice.user.dto.CustomerBankDto;
import test.danamon.microservice.user.services.CustomerBankService;

@Component
public class CustomerListener {
    
    @Autowired
    private CustomerBankService customerBankService;

    @Value("${rabbitmq.queue.balanceuser}")
    private String  queueName;

    @Value("${rabbitmq.exchange.balanceuser}")
    private String exchange;

    @RabbitListener(queues = "${rabbitmq.queue.balanceuser}")
    @Transactional(rollbackFor=Exception.class)
    public void handleMessage(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        CustomerBankDto customerBankDto = mapper.readValue(json, CustomerBankDto.class);
        this.customerBankService.patchCustomerBank(customerBankDto);
    }
}
