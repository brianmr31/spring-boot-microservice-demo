package test.danamon.microservice.transaction.dto;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.danamon.microservice.transaction.entities.CategoryTransactionEntity;
import test.danamon.microservice.transaction.entities.TransactionEntity;

@Getter
@Setter
@NoArgsConstructor
public class TransactionDto {
 
    @NotEmpty(message = "noRekeningSrc is mandatory")
    private String noRekeningSrc;

    @NotEmpty(message = "noRekeningDst is mandatory")
    private String noRekeningDst;

    @NotEmpty(message = "amount is mandatory")
    private String amount;

    private String noted;

    @NotEmpty(message = "categoryId is mandatory")
    private String categoryId;

    public String toJson(){
        ObjectMapper mapper = new ObjectMapper();
        String result="";
        try {
            result = mapper.writeValueAsString(this);
        } catch (JsonGenerationException | JsonMappingException  e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result ;
    }

    public TransactionEntity toEntity(CategoryTransactionEntity categoryTransactionEntity, CustomerBankDto[] customerBank){
        TransactionEntity tmp = new TransactionEntity();
        if( this.noRekeningSrc != null ){
            tmp.setCustomerSrcId(this.noRekeningSrc);
        }
        if( this.noRekeningDst != null ){
            tmp.setCustomerDstId(this.noRekeningDst);
        }
        if( this.amount != null ){
            tmp.setAmount(this.amount);
        }
        if( this.noted != null ){
            tmp.setNoted(this.noted);
        }
        tmp.setNoRekeningSrc(customerBank[0].getNoRekening());
        tmp.setNoRekeningDst(customerBank[1].getNoRekening());
        tmp.setCategory(categoryTransactionEntity);
        return tmp;
    }
}
