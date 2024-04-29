package test.danamon.microservice.logging.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import test.danamon.microservice.logging.dto.LogDto;
import test.danamon.microservice.logging.dto.MessageDto;
import test.danamon.microservice.logging.entities.LogEntity;
import test.danamon.microservice.logging.services.LoggingService;

@RestController
public class LogController {
    
    @Autowired
    private LoggingService loggingService;

    @GetMapping("/api/v1/loggings")
    public List<LogEntity> findAll(){
        return this.loggingService.findAll();
    }

    @PostMapping("/api/v1/loggings")
    public MessageDto save(@Valid @RequestBody LogDto log){
        return this.loggingService.saveLog(log);
    }
}
