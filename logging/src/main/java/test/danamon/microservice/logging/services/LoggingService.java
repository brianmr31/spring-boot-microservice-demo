package test.danamon.microservice.logging.services;

import java.util.List;

import test.danamon.microservice.logging.dto.LogDto;
import test.danamon.microservice.logging.dto.MessageDto;
import test.danamon.microservice.logging.entities.LogEntity;

public interface LoggingService {
    
    public MessageDto saveLog(LogDto log);
    public List<LogEntity> findAll();
}
