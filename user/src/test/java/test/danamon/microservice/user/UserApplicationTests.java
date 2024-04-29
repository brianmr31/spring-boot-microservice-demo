package test.danamon.microservice.user;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import test.danamon.microservice.user.entities.BankEntity;
import test.danamon.microservice.user.repositories.BankRepository;
import test.danamon.microservice.user.services.BankService;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserApplicationTests {

	@MockBean
	private BankRepository bankRepository;

	@Autowired
	private BankService bankService;

	@Test
    public void BankService_findAll(){
        List<BankEntity> mockdata = new ArrayList<BankEntity>();
        BankEntity tmp = new BankEntity();
        tmp.setId("");
		tmp.setName("test");
        mockdata.add(tmp);
        given( bankRepository.findAll()).willReturn( mockdata );
		System.out.println( mockdata.size() );
        List<BankEntity> result = this.bankService.findAll();
        assertEquals(result.size(), mockdata.size());
    }   
}
