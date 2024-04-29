package test.danamon.microservice.transaction.dto;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
