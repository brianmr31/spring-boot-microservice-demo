package test.danamon.microservice.logging;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import test.danamon.microservice.logging.entities.LogEntity;
import test.danamon.microservice.logging.repositories.LoggingRepository;
import test.danamon.microservice.logging.services.LoggingService;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LoggingApplicationTests {

	@MockBean
    private LoggingRepository loggingRepository; 

    @Autowired
    private LoggingService loggingService;

	@Test
    public void LoggingService_findAll(){
        List<LogEntity> mockdata = new ArrayList<LogEntity>();
        LogEntity tmp = new LogEntity();
        tmp.setId("");
		tmp.setLog("\"msg\":\"Hello World\"");
		tmp.setService("user-service");
        mockdata.add(tmp);
        given( loggingRepository.findAll()).willReturn( mockdata );

        List<LogEntity> result = this.loggingService.findAll();
        assertEquals(result.size(), mockdata.size());
    }   
}
