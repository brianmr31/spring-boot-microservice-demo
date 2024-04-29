package test.danamon.microservice.user.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.danamon.microservice.user.entities.CustomerBankEntity;

@Getter
@Setter
@NoArgsConstructor
public class CustomerBankDto {

    private String id;
    @NotEmpty(message = "noRekening is mandatory")
    private String noRekening;

    private String namaCustomer;
    private String balance;
    private BankDto bank;

    public CustomerBankEntity marge(CustomerBankEntity tmp ){
        if( ! this.noRekening.equals("") ){
            tmp.setNoRekening(this.noRekening);
        }
        if( this.namaCustomer != null  ){
            tmp.setNamaCustomer(this.namaCustomer);
        }
        if( this.balance != null ){
            tmp.setBalance( Double.parseDouble( this.balance) );
        }
        return tmp;
    }
}
