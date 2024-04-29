package test.danamon.microservice.logging.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.danamon.microservice.logging.entities.LogEntity;

@Getter
@Setter
@NoArgsConstructor
public class LogDto {

    @NotEmpty(message = "service is mandatory")
    public String service;

    @NotEmpty(message = "log is mandatory")
    public String log;

    public LogEntity toEntity() {
        return new LogEntity(this.service, this.log);
    }
}
