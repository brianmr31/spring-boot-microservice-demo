package test.danamon.microservice.transaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.danamon.microservice.transaction.entities.TransactionEntity;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, String>{
    
}
