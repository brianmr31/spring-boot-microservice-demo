package test.danamon.microservice.logging.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import test.danamon.microservice.logging.dto.LogDto;
import test.danamon.microservice.logging.services.LoggingService;

@Component
public class LoggingListener {
    
    @Autowired
    private LoggingService loggingService;

    @Value("${rabbitmq.queue}")
    private String  queueName;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void handleMessage(String json) throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        LogDto logDto = mapper.readValue(json, LogDto.class);
        this.loggingService.saveLog(logDto);
    }
}
