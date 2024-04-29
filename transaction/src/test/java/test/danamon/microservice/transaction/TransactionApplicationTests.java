package test.danamon.microservice.transaction;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import test.danamon.microservice.transaction.entities.CategoryTransactionEntity;
import test.danamon.microservice.transaction.repositories.CategoryTransactionRepository;
import test.danamon.microservice.transaction.services.CategoryTransactionService;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TransactionApplicationTests {

	@MockBean
    private CategoryTransactionRepository categoryTransactionRepository; 

    @Autowired
    private CategoryTransactionService categoryTransactionService;

	@Test
    public void CategoryTransactionService_findAll(){
        List<CategoryTransactionEntity> mockdata = new ArrayList<CategoryTransactionEntity>();
        CategoryTransactionEntity tmp = new CategoryTransactionEntity();
        tmp.setId("");
		tmp.setName("test");
        mockdata.add(tmp);
        given( categoryTransactionRepository.findAll()).willReturn( mockdata );
		System.out.println( mockdata.size() );
        List<CategoryTransactionEntity> result = this.categoryTransactionService.findAll();
        assertEquals(result.size(), mockdata.size());
    }   
}
