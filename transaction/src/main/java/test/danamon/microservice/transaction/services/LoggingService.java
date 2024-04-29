package test.danamon.microservice.transaction.services;

import test.danamon.microservice.transaction.dto.LogDto;

public interface LoggingService {
    
    public void publishMessage(LogDto logDto);
}
