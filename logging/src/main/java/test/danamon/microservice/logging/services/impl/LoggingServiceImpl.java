package test.danamon.microservice.logging.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.danamon.microservice.logging.dto.LogDto;
import test.danamon.microservice.logging.dto.MessageDto;
import test.danamon.microservice.logging.entities.LogEntity;
import test.danamon.microservice.logging.repositories.LoggingRepository;
import test.danamon.microservice.logging.services.LoggingService;

@Service
public class LoggingServiceImpl implements LoggingService {

    @Autowired
    private LoggingRepository loggingRepository;

    @Override
    public MessageDto saveLog(LogDto log) {
        String result = "ok";
        try{
            this.loggingRepository.save(log.toEntity());
        } catch (Exception e) {
            e.printStackTrace();;
            result = "err";
        }
        return new MessageDto(result);
    }

    @Override
    public List<LogEntity> findAll() {
        return this.loggingRepository.findAll();
    }
    
}
