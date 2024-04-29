package test.danamon.microservice.transaction.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CustomerBankDto implements Serializable {
    
    private String id;
    private String noRekening;

    private String namaCustomer;
    private double balance;
    private BankDto bank;
}
