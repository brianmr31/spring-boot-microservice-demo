package test.danamon.microservice.transaction.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LogDto {

    @NotEmpty(message = "service is mandatory")
    public String service;

    @NotEmpty(message = "log is mandatory")
    public String log;
}
