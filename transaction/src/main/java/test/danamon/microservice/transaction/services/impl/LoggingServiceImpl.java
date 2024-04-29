package test.danamon.microservice.transaction.services.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.danamon.microservice.transaction.dto.LogDto;
import test.danamon.microservice.transaction.services.LoggingService;

@Service
public class LoggingServiceImpl implements LoggingService {
    
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.exchange}")
    String exchange;

    @Value("${rabbitmq.routingkey}")
    String routingkey;

    @Transactional(rollbackFor=Exception.class)
    public void publishMessage(LogDto logDto){
        amqpTemplate.convertAndSend(exchange, routingkey, logDto);
    }
}
