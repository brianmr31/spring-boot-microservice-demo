package test.danamon.microservice.logging.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import test.danamon.microservice.logging.entities.LogEntity;

@Repository
public interface LoggingRepository extends MongoRepository<LogEntity, String> {
    
}
