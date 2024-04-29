package test.danamon.microservice.user.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BankDto implements Serializable {
    
    private String id;
    private String kode;
    private String name;
}

