package test.danamon.microservice.logging.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document("logging")
public class LogEntity {
    
    @Id
    public String id;
    public String service;
    public String log;

    public LogEntity(String service, String log) {
        this.service = service;
        this.log = log;
    }
}
